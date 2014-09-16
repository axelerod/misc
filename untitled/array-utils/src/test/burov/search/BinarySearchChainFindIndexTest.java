package burov.search;

/**
 *
 * @author oburov
 */
public class BinarySearchChainFindIndexTest extends CommonSearchFindIndexTest {
	public BinarySearchChainFindIndexTest(int[] testArray, int valueToSearch, int result) {
		super(testArray, valueToSearch, result);
	}

	@Override
	public void setAlgorithm() {
		algorithm = new BinarySearchChain();
	}
}
