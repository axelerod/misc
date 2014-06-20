package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public class CounterRunner {

    private Container<Integer> counter = new Container<Integer>(new Integer(0));

    public void runCounter() throws InterruptedException{
        Thread r1 = startRunnable(0);
        Thread r2 = startRunnable(1);
        r1.join();
        r2.join();
    }

    private Thread startRunnable(int condition) throws InterruptedException {
        Runnable runnable1 = getRunnable(condition);

        Thread thread = new Thread(runnable1);
        thread.start();
        return thread;
    }

    private Runnable getRunnable(final int condition) throws InterruptedException{
        return new Runnable() {
            public void run(){
                try {
                    new SharedCounter(counter, condition).increasecounter();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e) ;
                }
            }
        };
    }

    public Container<Integer> getCounter() {
        return counter;
    }
}
