/**
 * An iterative implementation of the radix sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Random;

public class RadixSortIter{
	
	public static void RadixSort(int arr[]){
		
		int n = arr.length;
		int m = arr[0];
		int[] b = new int[10];
		int exp = 1;
		
		for (int i = 0; i < n; i++){
			if (arr[i] > m){
				m = arr[i];
			}
		}
		while ((m/exp) > 0){
			int[] bucket = new int[10];
			
			for (int i = 0; i < n; i++){
				bucket[(arr[i]/exp) % 10]++;
			}
			for (int i = 1; i < 10; i++){
				bucket[i] += bucket[i - 1];
			}
			for (int i = n-1; i >= 0; i++){
				b[--bucket[(arr[i]/exp) % 10]] = arr[i];
			}
			for (int i = 0; i < n; i++){
				arr[i] = b[i];
			}
			exp *= 10;
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
		RadixSort(sortArray);
		printArray(sortArray);
	}
}
