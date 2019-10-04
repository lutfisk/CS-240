/**
 * An iterative implementation of the quick sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class QuickSortIter {
	
	public static int partition(int arr[], int low, int high){
		
		int pivot = arr[high]; 
		int i = (low-1);
		for (int j = low; j < high; j++){
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
		
		int[] stack = new int[high - low + 1];
        int top = -1;

        stack[top++] = low;
        stack[top++] = high;
 
        while (top >= 0){
            high = stack[top--];
            low = stack[top--];
            int pivot = partition(arr, low, high);
            if (pivot - 1 > low){
            	stack[top++] = low;
                stack[top++] = pivot - 1;
            }
            if (pivot + 1 < high){
                stack[++top] = pivot + 1;
                stack[++top] = high;
            }
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
		QuickSort(sortArray, sortArray[0], sortArray[sortArray.length-1]);
		printArray(sortArray);
	}
}

