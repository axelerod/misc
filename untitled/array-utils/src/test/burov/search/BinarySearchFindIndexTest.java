package burov.search;

public class BinarySearchFindIndexTest extends CommonSearchFindIndexTest {

	public BinarySearchFindIndexTest(int[] testArray, int valueToSearch, int result) {
		super(testArray, valueToSearch, result);
	}

	@Override
	public void setAlgorithm() {
		algorithm = new BinarySearch();
	}
}
