/**
 * An iterative implementation of the insertion sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class InsertionSortIter{
	
	public static void InsertionSort(int arr[]){
		
		int n = arr.length;
		for (int i = 0; i < n; i++){
			int j = (i-1);
			int key = arr[i];					//value to compare
			
			while (j >= 0 && arr[j] > key){		//move num > key ahead one position
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
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
		InsertionSort(sortArray);
		printArray(sortArray);
	}

}
