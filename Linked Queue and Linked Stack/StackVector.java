/**
  	Data Structure Stack implemented with fixed vectors
 
	@author Lutfi Haji-Cheteh
 
 */
import java.util.Vector;

public class StackVector<T> implements StackInterface<T> {
	
	Vector<T> stack;
	
	public StackVector(){
		stack = new Vector<T>();
	}
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry){
		stack.add(newEntry);
	}

	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T tempData = stack.lastElement();
			int index = stack.lastIndexOf(tempData);
			return stack.remove(index);
		}
	}
	
	/** Retrieves this stack's top entry.
    @return  The object at the top of the stack.
    @throws  EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			return stack.lastElement();
		}
	}
	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	/** Removes all entries from this stack. */
	public void clear(){
		stack.removeAllElements();
	}
}
