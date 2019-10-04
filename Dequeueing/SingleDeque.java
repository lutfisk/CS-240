/**
  	Deque implementation using single linked nodes. 
 
	@author Lutfi Haji-Cheteh
 */
public class SingleDeque<T> implements DequeInterface<T>{
	
	private SingleNode<T> head;
	private SingleNode<T> tail;
	
	public SingleDeque(){
		head = null;
		tail = null;
	}
	
	public SingleDeque(SingleNode<T> firstNode){
		head = firstNode;
		tail = firstNode;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
    @param newEntry  An object to be added. */
	public void addToFront(T newEntry){
		SingleNode<T> newNode = new SingleNode<T>(newEntry);
		if (head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			head.setPrev(newNode);
			head = newNode;
		}
	}
	public void addToBack(T newEntry){
		SingleNode<T> newNode = new SingleNode<T>(newEntry);
		if (tail == null){
			head = newNode;
			tail = newNode;
		}
		else{
			newNode.setPrev(tail);
			tail = newNode;
		}
	}
	
	/** Removes and returns the front/back entry of this dequeue.
    @return  The object at the front/back of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T removeFront(){
		if (head == null){
			throw new EmptyQueueException();
		}
		else{
			T tempData = head.getData();
			head.setData(null);
			if (head == tail){
				head = null;
				tail = null;
			}
			else{
				tail = tail.getPrev();
				head.setPrev(null);
			}
			return tempData;
		}
	}
	public T removeBack(){
		if (tail == null){
			throw new EmptyQueueException();
		}
		else{
			T tempData = tail.getData();
			SingleNode<T> tempTail = tail.getPrev();
			tail.setPrev(null);
			tail.setData(null);
			tail = tempTail;
			return tempData;
		}
	}
	
	/** Retrieves the front/back entry of this dequeue.
    @return  The object at the front/back of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T getFront(){
		if (head == null){
			throw new EmptyQueueException();
		}
		else{
			return head.getData();
		}
	}
	public T getBack(){
		if (tail == null){
			throw new EmptyQueueException();
		}
		else{
			return tail.getData();
		}
	}

	/**  Detects whether this dequeue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		if (head == null && tail == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	 /**  Removes all entries from this dequeue. */
	 public void clear(){
		 if (isEmpty()){
			  throw new EmptyQueueException();
		  }
		  else{
			  SingleNode<T> lastNode = tail;
			  while (lastNode.getPrev() != null){
				  lastNode.setData(null);
				  lastNode.setPrev(null);
			  }
			  head.setData(null);
			  head = null;
			  tail = null;
		  }
	 }
	
}


