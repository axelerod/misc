package burov;

/**
 * Created by IntelliJ IDEA.
 * User: alexey
 * Date: 27.06.14
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 */
public class CounterRunner2Threads extends CounterRunner {
    public void runCounter() throws InterruptedException {
        int divisor = 2;
        Thread r1 = startRunnable(0, divisor);
        Thread r2 = startRunnable(1, divisor);
        r1.join();
        r2.join();
    }
}
