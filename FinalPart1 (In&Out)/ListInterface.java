/**
  	An interface for ADT list.
 
	@author Lutfi Haji-Cheteh
 */
public interface ListInterface<T>{
	
	/** Add an entry to the end of list.
		List size increases by 1.
		Other item positions are unaffected.
		@param item	The objected to be added.*/
	public void add(T item);
	
	/** Add an entry at a specified position in the list.
		List size increases by 1.
		Other item positions at or after the given index will be increased by 1.
		@param position	The index at which the item is to be added.
		@param item		The object to be added
		@throws IndexOutOfBoundsException if position < 1 or > length of array. */
	public void add(int position, T item);
	
	/** Remove an item from a specified position in the list.
		List size decreases by 1.
		Other item positions at or after the given index will be decreased by 1.
		@param position	The index at which the item is to be removed.
		@throws IndexOutOfBoundsException if position < 1 or > length of array.
		@return The removed item at given position. */
	public T remove(int position);
	
	/** View an item from a specified position in the list.
		@param position	The index at which the item is to be viewed.
		@throws IndexOutOfBoundsException if position < 1 or > length of array.
		@return The item at given position. */
	public T view(int position);
	
	/** Get the length of the list.
		@return The length of the list. */
	public int getLength();
	
	/** Checks if the list is empty.
		@return True if the list is empty, otherwise false. */
	public boolean isEmpty();
	
	/** Clears all entries from the list.
		List size resets to zero. */
	public void clear();

}

