package burov.search;

/**
 * @author oburov
 */
public class BinarySearchChain implements Search {

	@Override
	public int findIndex(int[] array, int targetValue) {

		if (ArrayUtils.isEmpty(array)) {
			return NOT_FOUND;
		}
		ChainElement chainElement = getStartChainElement();

		// start chain
		return chainElement.findIndex(new ArraySegment(array, targetValue, 0, array.length));
	}

	private IsSingleChainElement getStartChainElement() {
		//setupChain
		SplitChainElement splitChainElement = new SplitChainElement(null);
		IsTwoOrLessChainElement twoOrLessChainElement = new IsTwoOrLessChainElement(splitChainElement);
		IsOutOfRangeChainElement isOutOfRangeChainElement = new IsOutOfRangeChainElement(twoOrLessChainElement);
		IsSingleChainElement isSingleChainElement = new IsSingleChainElement(isOutOfRangeChainElement);
		// chain looped here
		splitChainElement.setNext(isOutOfRangeChainElement);

		return isSingleChainElement;
	}

	private static abstract class ChainElement {
		protected ChainElement next;

		protected ChainElement(ChainElement next) {
			this.next = next;
		}

		public abstract int findIndex(ArraySegment segment);

		public void setNext(ChainElement next) {
			this.next = next;
		}
	}

	private static class IsSingleChainElement extends ChainElement {
		private IsSingleChainElement(ChainElement next) {
			super(next);
		}

		@Override
		public int findIndex(ArraySegment segment) {
			int[] array = segment.getArray();
			// check array with 1 element
			if (array.length == 1) {
				return array[0] == segment.getTargetValue() ? 0 : NOT_FOUND;
			}

			return next.findIndex(segment);
		}
	}

	private static class IsOutOfRangeChainElement extends ChainElement {
		private IsOutOfRangeChainElement(ChainElement next) {
			super(next);
		}

		@Override
		public int findIndex(ArraySegment segment) {
			if (ArrayUtils.outOfArrayEdges(
					segment.getArray(), segment.getTargetValue(), segment.getStartIndex(), segment.getEndIndex())) {
				return NOT_FOUND;
			}

			return next.findIndex(segment);
		}
	}

	private static class IsTwoOrLessChainElement extends ChainElement {
		private IsTwoOrLessChainElement(ChainElement next) {
			super(next);
		}

		@Override
		public int findIndex(ArraySegment segment) {
			int[] array = segment.getArray();
			int targetValue = segment.getTargetValue();
			int startIndex = segment.getStartIndex();
			int endIndex = segment.getEndIndex();

			if ((endIndex - startIndex) <= 1) {
				if (array[startIndex] == targetValue) {
					return startIndex;
				} else if (array[endIndex] == targetValue) {
					return endIndex;
				} else {
					return NOT_FOUND;
				}
			}

			return next.findIndex(segment);
		}
	}

	private static class SplitChainElement extends ChainElement{
		private SplitChainElement(ChainElement next) {
			super(next);
		}

		@Override
		public int findIndex(ArraySegment segment) {
			int[] array = segment.getArray();
			int targetValue = segment.getTargetValue();
			int startIndex = segment.getStartIndex();
			int endIndex = segment.getEndIndex();

			int averageIndex = NumberUtils.findAverage(startIndex, endIndex);

			return (array[averageIndex] > targetValue)
					? next.findIndex(new ArraySegment(array, targetValue, averageIndex + 1, endIndex))
					: next.findIndex(new ArraySegment(array, targetValue, startIndex, averageIndex));
		}
	}

	private static class ArraySegment {
		private int[] array;
		private int targetValue;
		private int startIndex;
		private int endIndex;

		private ArraySegment(int[] array, int targetValue, int startIndex, int endIndex) {
			this.array = array;
			this.targetValue = targetValue;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}

		public int[] getArray() {
			return array;
		}

		public int getTargetValue() {
			return targetValue;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}
	}

}
