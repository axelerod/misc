package burov;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: alexey
 * Date: 27.06.14
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 */
public class CounterRunnerNThreads extends CounterRunner {

	private int threadsCount;
	private int bound;
	private List<Thread> threadList;

	public CounterRunnerNThreads(int threadsCount, int bound) {
		this.threadsCount = threadsCount;
		threadList = new ArrayList<Thread>(threadsCount);
		this.bound = bound;
	}

	public void runCounter() throws InterruptedException {
		for (int i = 0; i < threadsCount; i++) {
			Thread thread = getThread(i, threadsCount, bound);
			threadList.add(thread);
		}
		for (Thread thread : threadList) {
			thread.join();
		}
    }
}
