/**
 * A recursive implementation of the radix sort algorithm.
 *
 * @author Lutfi Haji-Cheteh
 * @version 1.0
 */
import java.util.Arrays;
import java.util.Random;

public class RadixSortRecu{
	
	public static int maximum(int arr[], int n){
		int max = arr[0];
		for (int i = 1; i < n; i++){
			if (arr[i] > max){
				max = arr[i];
			}
		}
			return max;
	}
	
	public static void counter(int arr[], int n, int pow){
		
		int result[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for (i = 1; i < 10; i++){
			count[(arr[i]/pow)%10]++; 
		}
		for (i = 1; i < 10; i++){
			count[i] += count[i-1];
		}
		for (i = n-1; i >=0; i--){
			result[count[(arr[i]/pow)%10]-1] = arr[i];
			count[(arr[i]/pow)%10]--;
		}
		for (i = 0; i < n; i++){
			arr[i] = result[i];
		}
	}
	
	public static void RadixSort(int arr[], int n){
		
		int max = maximum(arr, n);
		for (int pow = 1; (max/pow) > 0; pow *= 10){
			counter(arr, n, pow);
		}
	}
	
	public static void main(String[] args){
		int[] sortArray = new int[10];
		Random num = new Random();
		for (int j = 0; j < sortArray.length; j++){
			sortArray[j] = (num.nextInt(100));
		}
		RadixSortRecu a = new RadixSortRecu();
		a.RadixSort(sortArray, sortArray.length);
		for (int i = 0; i < sortArray.length; i++){
			System.out.println(sortArray[i] + " ");
		}
	}

}


