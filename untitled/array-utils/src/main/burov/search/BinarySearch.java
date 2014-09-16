package burov.search;

/**
 * Class provides binary search algorithm for descending sorted array.
 * @author Burov Oleksii
 */
public class BinarySearch implements Search {

	private int iterationsNumber;

	@Override
	public int findIndex(int[] array, int targetValue) {
		// check null or empty array
		if (ArrayUtils.isEmpty(array)) {
			return NOT_FOUND;
		}

		// check array with 1 element
		if (array.length == 1) {
			return array[0] == targetValue ? 0 : NOT_FOUND;
		}

		iterationsNumber = 0;

		return find(array, targetValue, 0, array.length - 1);
	}

	private int find(int[] array, int targetValue, int startIndex, int endIndex) {

		if (ArrayUtils.outOfArrayEdges(array, targetValue, startIndex, endIndex)) {
			return NOT_FOUND;
		}

		// one, two elements segment
		if ((endIndex - startIndex) <= 1) {
			if (array[startIndex] == targetValue) {
				return startIndex;
			} else if (array[endIndex] == targetValue) {
				return endIndex;
			} else {
				return NOT_FOUND;
			}
		}
		// 3 or more elements segment
		else {
			iterationsNumber++;
			int averageIndex = NumberUtils.findAverage(startIndex, endIndex);

			return (array[averageIndex] > targetValue) ?
					find(array, targetValue, averageIndex + 1, endIndex)
					: find(array, targetValue, startIndex, averageIndex);

		}
	}

	public int getIterationsNumber() {
		return iterationsNumber;
	}
}
