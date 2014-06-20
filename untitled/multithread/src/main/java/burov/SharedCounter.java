package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public class SharedCounter {
	private Integer counter;
	private Integer condition;

	public SharedCounter(Integer counter, Integer condition) {
		this.counter = counter;
		this.condition = condition;
	}

	public void increasecounter() throws InterruptedException {
		synchronized (counter) {
			while (counter < 10) {
				while(counter.intValue() % 2 != condition) {
					counter.wait(0);
					counter.notifyAll();
				}
				counter++;
				System.out.println(Thread.currentThread() + "increase to " + counter);
			}
		}
	}
}
