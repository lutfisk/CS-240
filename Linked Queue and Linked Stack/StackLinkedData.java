/**
  	Data Structure Stack implemented with linked data
 
	@author Lutfi Haji-Cheteh
 
 */
public class StackLinkedData<T> implements StackInterface<T> {

	Node<T> head;
	
	public StackLinkedData(){
		head = null;
	}
	
	public StackLinkedData(Node<T> top){
		head = top;
	}
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry){
		Node<T> newNode = new Node<T>(newEntry, head);
		head = newNode;
		newNode = null;
	}
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			Node<T> tempNode = head;
			head = tempNode.getNext();
			return tempNode.getData();
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
			return head.getData();
		}
	}
	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
		if (head == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	 /** Removes all entries from this stack. */
	 public void clear(){
		 head = null;
	 }
}
