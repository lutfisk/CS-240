/**
 * A recursive implementation of the insertion sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class InsertionSortRecu{
	
	public static void InsertionSort(int arr[], int n){
	
		if (n <= 1){
			return;
		}
		InsertionSort(arr, n-1);
		
		int last = arr[n-1];
		int k = n-2;
		
		while (k >= 0 && arr[k] > last){
			arr[k+1] = arr[k];
			k--;
		}
		arr[k+1] = last;
	}
		
	public static void main(String[] args){
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int j = 0; j < sortArray.length; j++){
			sortArray[j] = (num.nextInt(100));
		}
		InsertionSort(sortArray, sortArray.length);
		for (int i = 0; i < sortArray.length; i++){
			System.out.println(sortArray[i] + " ");
		}
	}
}
