package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public abstract class CounterRunner {

    private Container<Integer> counter = new Container<Integer>(new Integer(0));

    private ConditionChecker checker = new ConditionChecker() {
        public boolean condition(int value, int divisor, int result) {
            return value % divisor == result;
        }
    };

    protected Thread startRunnable(int condition, int divisor) throws InterruptedException {
        Runnable runnable1 = getRunnable(condition, divisor);

        Thread thread = new Thread(runnable1);
        thread.start();
        return thread;
    }

    public abstract void runCounter() throws InterruptedException;

    private Runnable getRunnable(final int condition, final int divisor) throws InterruptedException {
        return new Runnable() {
            public void run() {
                try {
                    new SharedCounter(counter, condition, 100, divisor, checker).increasecounter();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public Container<Integer> getCounter() {
        return counter;
    }
}
