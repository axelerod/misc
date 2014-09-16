package burov.search;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsAverageTest {

	@Test
	public void testFindAverageOverflow() {
		int maxValue = Integer.MAX_VALUE;
		BinarySearch algorithm = new BinarySearch();

		int actualResult = NumberUtils.findAverage(maxValue - 2, maxValue);
		Assert.assertTrue((maxValue - 1) == actualResult);
	}
}