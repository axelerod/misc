package burov.search;

import static burov.search.Search.NOT_FOUND;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author oburov
 */
@RunWith(Parameterized.class)
public abstract class CommonSearchFindIndexTest {
	public static final int TO_SEARCH = 333;
	public static final int MAX_VALUE_TO_SEARCH = Integer.MAX_VALUE / 8;
	protected int[] testArray;
	protected int valueToSearch;
	protected int expectedValue;
	protected Search algorithm;

	public CommonSearchFindIndexTest(int[] testArray, int valueToSearch, int result) {
		this.valueToSearch = valueToSearch;
		this.testArray = testArray;
		this.expectedValue = result;
	}
	
	@Before
	public abstract void setAlgorithm();

	@Parameterized.Parameters(name = "{index}: binarySearch array {0}, value to search {1}, expected result {2}")
	public static Iterable<Object[]> data() {
		int[] bigArrayTest = getArray(0, MAX_VALUE_TO_SEARCH);
		return Arrays.asList(new Object[][]{
				{null, 5, NOT_FOUND},
				{new int[0], TO_SEARCH, NOT_FOUND},
				{new int[]{5, 3}, TO_SEARCH, NOT_FOUND},
				{new int[]{5, 3, 1}, TO_SEARCH, NOT_FOUND},
				{new int[]{34, 5, 3, 1}, TO_SEARCH, NOT_FOUND},
				{new int[]{245, 34, 5, 3, 1}, TO_SEARCH, NOT_FOUND},
				{new int[]{435, 34, 5, 3, 1}, TO_SEARCH, NOT_FOUND},
				{new int[]{TO_SEARCH}, TO_SEARCH, 0},
				{new int[]{TO_SEARCH, TO_SEARCH, TO_SEARCH}, TO_SEARCH, 0},
				{bigArrayTest, MAX_VALUE_TO_SEARCH, 0},
				{bigArrayTest, MAX_VALUE_TO_SEARCH - 2, 2},
				{bigArrayTest, 2, MAX_VALUE_TO_SEARCH - 2},
				{bigArrayTest, 0, MAX_VALUE_TO_SEARCH},
		});
	}

	private static int[] getArray(int minValue, int maxValue) {
		int length = maxValue - minValue + 1;
		int[] testArray = new int[length];
		for (int i = 0; i < length; i ++) {
			testArray[i] = maxValue - i;
		}
		return testArray;
	}

	@Test
	public void testFindIndex() {
		Assert.assertEquals(expectedValue, algorithm.findIndex(testArray, valueToSearch));
	}
}
