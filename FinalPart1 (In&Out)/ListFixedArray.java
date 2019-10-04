/**
  	An implementation of ADT list using fixed size array.
 
	@author Lutfi Haji-Cheteh
 */
public class ListFixedArray<T> implements ListInterface<T>{
	
	public static final int MAX_CAPACITY = 10;
	private T[] list;
	private int numOfEntries;
	
	public ListFixedArray(int size){
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[size];
		list = tempList;
		numOfEntries = 0;
	}
	
	public void add(T item){
		list[numOfEntries++] = item;
	}
	
	public void add(int position, T item){
		if (position < 0 || position > numOfEntries){
			throw new IndexOutOfBoundsException();
		}
		else{
			list[position+1] = list[position];
			for (int i=numOfEntries-1; i>position; i--){
				list[i+1] = list[i];
			}
			list[position] = item;
			numOfEntries++;
		}
	}
	
	public T remove(int position){
		if (position < 0 || position >= numOfEntries){
			throw new IndexOutOfBoundsException();
		}
		else{
			T temp = list[position];
			for (int i=position; i<numOfEntries; i++){
				list[i] = list[i+1];
			}
			list[numOfEntries-1] = null;
			numOfEntries--;
			return temp;
		}
	}
	
	public T view(int position){
		if (position < 0 || position >= numOfEntries){
			throw new IndexOutOfBoundsException();
		}
		else{
			return list[position];
		}
	}
	
	public int getLength(){
		return numOfEntries;
	}
	
	public boolean isEmpty(){
		return numOfEntries == 0;
	}
	
	public void clear(){
		for (int i=0; i<MAX_CAPACITY; i++){
			list[i] = null;
		}
		numOfEntries = 0;
	}

}


