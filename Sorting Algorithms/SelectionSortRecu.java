/**
 * A recursive implementation of the selective sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class SelectionSortRecu{
	
	public static int minEntry(int arr[], int i, int j){
		
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
	
	public static void SelectionSort(int arr[], int n, int entry){
		
		if (entry == n){
			return;
		}
		int min = minEntry(arr, entry, n-1);
		if (min != entry){
			int temp = arr[min];
			arr[min] = arr[entry];
			arr[entry] = temp;
		}
		SelectionSort(arr, n, entry+1);
	}
	
	public static void main(String args[]){
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int j = 0; j < sortArray.length; j++){
			sortArray[j] = (num.nextInt(100));
		}	
		SelectionSort(sortArray, sortArray.length, 0);
		for (int i = 0; i < sortArray.length; i++){
			System.out.println(sortArray[i] + " ");
		}
	}
}

