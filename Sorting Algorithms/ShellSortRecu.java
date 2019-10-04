/**
 * A recursive implementation of the shell sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class ShellSortRecu{
	
	public static void ShellSort(int arr[], int low, int high, int pow){
		
		if (pow > 0){
			int gap = (int)Math.pow(2, pow)-1;
			for (int i = low; i < (low+gap); i++){
				gapSort(arr, i, low, gap);
			}
			ShellSort(arr, low, high, pow-1);
		}
	}
	
	public static void gapSort(int arr[], int low, int high, int gap){
		
		int j;
		for (int k = (low+gap); k <= high; k += gap){
			int entry = arr[k];
			for (j = (k-gap); j >= low && entry < arr[j]; j -= gap){
				arr[j+gap] = arr[j];
			}
			arr[j+gap] = entry;
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
		ShellSort(sortArray, 0, sortArray.length-1, (int)(Math.log(sortArray.length)/Math.log(2)));
		printArray(sortArray);
	}
}
