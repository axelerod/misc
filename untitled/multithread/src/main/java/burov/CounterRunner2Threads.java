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
        Thread r1 = getThread(0, divisor, 100);
        Thread r2 = getThread(1, divisor, 100);
        r1.join();
        r2.join();
    }
}
