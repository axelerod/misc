package burov.deadlock;

import java.util.Map;

/**
 * (c) Swissquote 7/10/14
 *
 * @author oburov
 */
public class ThreadChecker {
	private Map<Thread, Runnable> unitsOfWork;

	public ThreadChecker(Map<Thread, Runnable> unitsOfWork) {
		this.unitsOfWork = unitsOfWork;
	}

	public void detectAndResolveDeadLocks(){
		while (allBlocked()) {
			//stopOne(); //doesn't work
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Checker interrupted during sleep");
		}
	}

	private void stopOne() {
		Map.Entry<Thread, Runnable> next = unitsOfWork.entrySet().iterator().next();
		Thread thread = next.getKey();
		Runnable work = next.getValue();
		thread.stop();
		System.out.println("Thread.activeCount() " + Thread.activeCount());
		sleep();
		Thread newThread = new Thread(work);
		unitsOfWork.put(newThread, work);
		newThread.start();
	}

	private boolean allBlocked() {
		for (Thread thread : unitsOfWork.keySet()){
			System.out.println("Thread " + thread.getName() + " state " + thread.getState().name());
			if (thread.getState() != Thread.State.BLOCKED) {
				return false;
			}
		}

		return true;
	}

}
