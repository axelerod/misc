package burov.search;

/**
 * a
 * @author oburov
 */
public class ArrayUtils {

	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	public static boolean outOfArrayEdges(int[] array, int targetValue, int startIndex, int endIndex) {
		return ((targetValue > array[startIndex]) || targetValue < array[endIndex]);
	}
}
