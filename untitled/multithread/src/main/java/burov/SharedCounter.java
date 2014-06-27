package burov;

/**
 * (c) Swissquote 6/20/14
 *
 * @author oburov
 */
public class SharedCounter {
    private Container<Integer> counter;
    private Integer condition;
    private int bound;
    private int divisor;
    private ConditionChecker checker;

    public SharedCounter(Container<Integer> counter, Integer condition, int bound, int divisor, ConditionChecker checker) {
        this.counter = counter;
        this.condition = condition;
        this.bound = bound;
        this.divisor = divisor;
        this.checker = checker;
    }

    public void increasecounter() throws InterruptedException {
        synchronized (counter) {
            System.out.println(Thread.currentThread() + " synchronized " + counter.hashCode());
            while (checkBound(counter, bound)) {
                System.out.println(Thread.currentThread() + " while");

                while (!checker.condition(counter.getT().intValue(), divisor, condition)) {
                    if (!checkBound(counter, bound)) {
                        System.out.println("Never meet condition, we are at bound, return");
                        return;
                    }
                    System.out.println(Thread.currentThread() + " time to notify");
                    counter.notifyAll();
                    System.out.println(Thread.currentThread() + " time to wait");
                    counter.wait();
                    System.out.println(Thread.currentThread() + " awakened");
                }
                // check if we are in bound after awaking
                if (checkBound(counter, bound)) {
                    counter.setT(counter.getT() + 1);
                    System.out.println(Thread.currentThread() + " increase to " + counter.getT() + " and notify");
                    if (!checkBound(counter, bound)) {
                        System.out.println("At bound, notify other thread and return");
                        counter.notifyAll();
                        return;
                    }
                } else {
                    System.out.println("Check if we are in bound after awaking failed, notify all, return");
                    return;
                }
            }

        }
    }

    private boolean checkBound(Container<Integer> counter, int bound) {
        return counter.getT().intValue() < bound;
    }
}
