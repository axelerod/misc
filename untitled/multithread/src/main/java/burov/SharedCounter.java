package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public class SharedCounter {
    private Container<Integer> counter;
    private Integer condition;

    public SharedCounter(Container<Integer> counter, Integer condition) {
        this.counter = counter;
        this.condition = condition;
    }

    public void increasecounter() throws InterruptedException {
        while (counter.getT().intValue() < 100) {
            System.out.println(Thread.currentThread() + " while");
            synchronized (counter) {
                System.out.println(Thread.currentThread() + " synchronized " + counter.hashCode());
                while (counter.getT().intValue() % 2 != condition) {
                    System.out.println(Thread.currentThread() + " time to notify");
                    counter.notify();
                    System.out.println(Thread.currentThread() + " time to wait");
                    counter.wait();
                    System.out.println(Thread.currentThread() + " awakened");
                }
                counter.setT(counter.getT() + 1);
                System.out.println(Thread.currentThread() + " increase to " + counter.getT() + " and notify");
                counter.notify();
                System.out.println(Thread.currentThread() + " increase to " + counter.getT() + " and wait");
                if (counter.getT().intValue() == 100) {
                    return;
                }
                counter.wait();

            }
        }
    }
}
