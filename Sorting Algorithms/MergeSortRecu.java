/**
 * A recursive implementation of the merge sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class MergeSortRecu{
	
	public static void MergeSort(int arr[], int left, int mid, int right){
		
		int n = mid - left + 1;
		int m = right - mid;
		int L[] = new int[n];
		int R[] = new int[m];
		
		for (int i = 0; i < n; ++i){
			L[i] = arr[left + i];
		}
		for (int j = 0; j < m; ++j){
			R[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0, k = 1;
 
		while(i < n && j < m){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while(i < n){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < m){
			arr[k] = R[j];
			j++;
			k++;
		}
    }
	
	public static void sort(int arr[], int left, int right){
		
		if (left < right){
			int mid = (left + right)/2;
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			MergeSort(arr, left, mid, right);
		}
	}
	
	public static void main(String args[]){
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int j = 0; j < sortArray.length; j++){
			sortArray[j] = (num.nextInt(100));
		}
		MergeSortRecu a = new MergeSortRecu();
		a.sort(sortArray, 0, sortArray.length-1);
		for (int i = 0; i < sortArray.length; i++){
			System.out.println(sortArray[i] + " ");
		}
	}
}




