package burov.deadlock;

/**
 * (c) Swissquote 7/10/14
 *
 * @author oburov
 */
public class DeadLocker {
	private Object a;
	private Object b;

	public DeadLocker(Object a, Object b) {
		this.a = a;
		this.b = b;
	}

	public void lock() {
		synchronized (a) {
			System.out.println(getThreadName() + " Got lock on first object");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread " + getThreadName() + " was interrupted during sleep!");
			}

			synchronized (b) {
				System.out.println(getThreadName() + " Got lock on the second object");
			}
		}
	}

	private String getThreadName() {
		return Thread.currentThread().getName();
	}
}
