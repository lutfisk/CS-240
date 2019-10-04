/**
  	Deque implementation using double linked nodes. 
 
	@author Lutfi Haji-Cheteh
 */
public class DoubleDeque<T> implements DequeInterface<T>{
	
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	
	public DoubleDeque(){
		head = null;
		tail = null;
	}
	
	public DoubleDeque(DoubleNode<T> firstNode){
		head = firstNode;
		tail = firstNode;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
    @param newEntry  An object to be added. */
	public void addToFront(T newEntry){
		DoubleNode<T> newNode = new DoubleNode<T>(newEntry);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
	}
	public void addToBack(T newEntry){
		DoubleNode<T> newNode = new DoubleNode<T>(newEntry);
		if (tail == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.setNext(newNode);
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
			if (head.getNext() == null){
				head = null;
				tail = null;
			}
			else{
				head = head.getNext();
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
			tail.setData(null);
			if (tail.getPrev() == null){
				head = null;
				tail = null;
			}
			else{
				tail = tail.getPrev();
				tail.setNext(null);
			}
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
			  DoubleNode<T> lastNode = tail;
			  while (lastNode.getPrev() != null){
				  lastNode.setData(null);
				  lastNode.setPrev(null);
				  lastNode.setNext(null);
			  }
			  head.setData(null);
			  head.setNext(null);
			  head = null;
			  tail = null;
		  }
	}

}

