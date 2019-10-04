/**
 * An iterative implementation of the selective sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class SelectionSortIter{
	
	public static void SelectiveSort(int arr[]){
		
		int n = arr.length;
		for (int i = 0; i < (n-1); i++){
			int min = i;						//find the smallest number
			for (int j = (i+1); j < n; j++){
				if (arr[j] < arr[min]){
					min = j;
				}
			}
		int temp = arr[min];					//swap min with first element
		arr[min] = arr[i];
		arr[i] = temp;
		}
	}
	
	public static void printArray(int arr[]){
		int n = arr.length;
		for (int i = 0; i < n; i++){
			System.out.println(arr[i]+" ");
		}
	}
	
	public static void main(String[] args){
			
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int i = 0; i < sortArray.length; i++){
			sortArray[i] = (num.nextInt(100));
		}
		SelectiveSort(sortArray);
		printArray(sortArray);
	}
}



