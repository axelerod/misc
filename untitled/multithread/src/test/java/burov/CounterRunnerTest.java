package burov;

import org.junit.Assert;

public class CounterRunnerTest {

	public static final int EXPECTED = 100;

	@org.junit.Test
    public void testRun2ThreadsCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunner2Threads();
        counterRunner.runCounter();

        Assert.assertEquals(100, counterRunner.getCounter().getT().intValue());
    }

    @org.junit.Test
    public void testRun3ThreadsCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunnerNThreads(3, EXPECTED);
        counterRunner.runCounter();

        Assert.assertEquals(EXPECTED, counterRunner.getCounter().getT().intValue());
    }

	@org.junit.Test
    public void testRun13ThreadsCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunnerNThreads(13, EXPECTED);
        counterRunner.runCounter();
        Assert.assertEquals(EXPECTED, counterRunner.getCounter().getT().intValue());
    }


}