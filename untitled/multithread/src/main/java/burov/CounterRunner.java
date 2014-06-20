package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public class CounterRunner {

	private int counter;

	public void runCounter() {
		Runnable runnable1 = getRunnable(0);
		Runnable runnable2 = getRunnable(1);
		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}

	private Runnable getRunnable(final int condition) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					new SharedCounter(counter, condition).increasecounter();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
