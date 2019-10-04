/**
 * An iterative implementation of the merge sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class MergeSortIter{
	
	public static void MergeSort(int arr[]){
		
		int mid = arr.length / 2;
 
		int[] left = new int[mid];						//split left
		for (int i = 0; i < mid; i++){
			left[i] = arr[i];
		}
             
		int[] right = new int[arr.length - mid];		//split right
		for (int i = mid; i < arr.length; i++){
			right[i - mid] = arr[i];
		}
		MergeSort(left);
		MergeSort(right);
 
		int i = 0, j = 0, k = 0;
 
		while(i < left.length && j < right.length){		//merge
			if(left[i] < right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while(i < left.length){
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			arr[k] = right[j];
			j++;
			k++;
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
		MergeSort(sortArray);
		printArray(sortArray);
	}
}


