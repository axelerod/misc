package burov;

import org.junit.Assert;

public class CounterRunnerTest {

    @org.junit.Test
    public void testRun2ThreadsCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunner2Threads();
        counterRunner.runCounter();

        Assert.assertEquals(100, counterRunner.getCounter().getT().intValue());
    }

    @org.junit.Test
    public void testRun3ThreadsCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunner3Threads();
        counterRunner.runCounter();

        Assert.assertEquals(100, counterRunner.getCounter().getT().intValue());
    }
}