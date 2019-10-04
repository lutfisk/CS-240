/**
  	Data Structure Stack implemented with fixed sized array
 
	@author Lutfi Haji-Cheteh
 
 */
public class StackFixedArray<T> implements StackInterface<T>{
	
	private static final int MAX_CAPACITY = 10;
	private int numberOfEntries;
	private final T[] stack;
	
	public StackFixedArray(){
		this(MAX_CAPACITY);
	}
	
	public StackFixedArray(int size){
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[size];
		stack = tempStack;
		numberOfEntries = 0;
	}
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry) throws EmptyStackException{
		if (numberOfEntries >= stack.length){
			throw new EmptyStackException();
		}
		else{
			stack[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
	}
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T tempEntry = stack[numberOfEntries-1];
			stack[numberOfEntries-1] = null;
			numberOfEntries--;
			return tempEntry;
		}
	}
	
	/** Retrieves this stack's top entry.
    @return  The object at the top of the stack.
    @throws  EmptyStackException if the stack is empty. */
	public T peek(){
		if (isEmpty()){
			System.out.println("Stack is empty; nothing to look at!");
			return null;
		}
		else{
			return stack[numberOfEntries-1];
		}
	}

	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
		if (numberOfEntries == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	   /** Removes all entries from this stack. */
	   public void clear(){
		   for (int i=0; i<numberOfEntries; i++){
			   stack[i] = null;
		   }
		   numberOfEntries = 0;
	   }
}
