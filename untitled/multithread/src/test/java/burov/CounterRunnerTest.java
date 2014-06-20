package burov;

import org.junit.Assert;

public class CounterRunnerTest {

	@org.junit.Test
	public void testRunCounter() throws Exception {
        CounterRunner counterRunner = new CounterRunner();
        counterRunner.runCounter();

        Assert.assertEquals(100,counterRunner.getCounter().getT().intValue());
	}
}