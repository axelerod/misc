package burov.collections;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinkedListReverseTest {

	private LinkedList<Integer> toTest;
	private Integer[] expectedArray;

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{getIntegerLinkedList(1), new Integer[] {1}},
				{getIntegerLinkedList(2, 3), new Integer[] {3, 2}},
				{getIntegerLinkedList(1, 2, 3, 4, 5), new Integer[] {5, 4, 3, 2, 1}}
		});
	}

	public LinkedListReverseTest(LinkedList<Integer> toTest, Integer[] expectedArray) {
		this.toTest = toTest;
		this.expectedArray = expectedArray;
	}

	@Test
	public void testReverseSeveralElements() throws Exception {
		toTest.reverse();
		List<Integer> integers = toTest.toList();
		Assert.assertArrayEquals(expectedArray, integers.toArray(new Integer[expectedArray.length]));
	}

	private static LinkedList<Integer> getIntegerLinkedList(Integer... values) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer value : values) {
			list.add(value);
		}
		return list;
	}
}