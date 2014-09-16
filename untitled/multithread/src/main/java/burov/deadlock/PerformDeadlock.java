package burov.deadlock;

import java.util.HashMap;
import java.util.Map;

/**
 * (c) Swissquote 7/10/14
 * @author oburov
 */
public class PerformDeadlock {
	public void doStuff() {
		Object a = new Object();
		Object b = new Object();

		final DeadLocker deadLocker1 = new DeadLocker(a, b);
		final DeadLocker deadLocker2 = new DeadLocker(b, a);

		final Runnable r1 = getRunnable(deadLocker1);
		final Runnable r2 = getRunnable(deadLocker2);

		final Thread thread1 = new Thread(r1);
		final Thread thread2 = new Thread(r2);
		thread1.start();
		thread2.start();

		final Map<Thread, Runnable> threadRunnableMap = new HashMap<Thread, Runnable>();
		threadRunnableMap.put(thread1, r1);
		threadRunnableMap.put(thread2, r2);

		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			System.out.println("Sleep to perform deadlock");
		}

		Runnable resolveDeadLock = new Runnable() {
			@Override
			public void run() {
				ThreadChecker threadChecker = new ThreadChecker(threadRunnableMap);
				threadChecker.detectAndResolveDeadLocks();
			}
		};

		Thread thread = new Thread(resolveDeadLock);
		thread.start();
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			System.out.println("Main thread was interrupted, only lord could do this!");
		}
	}

	private Runnable getRunnable(final DeadLocker deadLocker) {
		return new Runnable() {
			@Override
			public void run() {
				deadLocker.lock();
			}
		};
	}
}
