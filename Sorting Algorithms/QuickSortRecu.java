/**
 * A recursive implementation of the quick sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class QuickSortRecu{
	
	public static int partition(int arr[], int low, int high){
		
		int pivot = arr[high];
		int i = (low-1);
		for (int j= low; j < high; j++){
			if (arr[j] <= pivot){
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	public static void QuickSort(int arr[], int low, int high){
		
		if (low < high){
			int piv = partition(arr, low, high);
			QuickSort(arr, low, piv-1);
			QuickSort(arr, piv+1, high);
		}
	}
	
	public static void main(String[] args){
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int j = 0; j < sortArray.length; j++){
			sortArray[j] = (num.nextInt(100));
		}
		QuickSortRecu a = new QuickSortRecu();
		a.QuickSort(sortArray, 0, sortArray.length-1);
		for (int i = 0; i < sortArray.length; i++){
			System.out.println(sortArray[i] + " ");
		}
	}

}





