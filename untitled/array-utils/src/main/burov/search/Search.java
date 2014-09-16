package burov.search;

/**
 *
 * @author oburov
 */
public interface Search {
	int NOT_FOUND = -1;

	int findIndex(int[] array, int targetValue);
}
