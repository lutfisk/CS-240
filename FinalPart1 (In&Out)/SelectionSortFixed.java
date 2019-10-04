/**
 * An implementation of the selective sort algorithm for linked stack.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
public class SelectionSortFixed<T>{
	
public static int minEntry(Integer arr[], int i, int j){
		
		if (i == j){
			return i;
		}
		int min = minEntry(arr, i+1, j);
		if (arr[i] < arr[min]){
			return i;
		}
		else{
			return min;
		}
	}
	
	public static void sort(Integer arr[], int n, int entry){
		if (entry == n){
			return;
		}
		int min = minEntry(arr, entry, n-1);
		if (min != entry){
			int temp = arr[min];
			arr[min] = arr[entry];
			arr[entry] = temp;
		}
		sort(arr, n, entry+1);
	}
}
