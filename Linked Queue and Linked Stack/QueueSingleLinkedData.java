/**
  	Data Structure Queue implemented with single linked data
 
	@author Lutfi Haji-Cheteh
 
 */
public class QueueSingleLinkedData<T> implements QueueInterface<T>{
	
	private Node<T> head;
	private Node<T> tail;
	
	public QueueSingleLinkedData(){
		head = null;
		tail = null;
	}

	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		Node<T> newNode = new Node<T>(newEntry, tail);
		if (isEmpty()){
			head = newNode;
		}
		tail = newNode;
	}
	
	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		else{
			Node<T> secondNode = tail.getNext();
			while (secondNode.getNext() !=head){
				secondNode = secondNode.getNext();
			}
			Node<T> tempHead = head;
			secondNode.setNext(null);
			head = secondNode;
			return tempHead.getData();
		}
	}
	
	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		else{
			return head.getData();
		}
	}
	
	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		if (tail == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		head = null;
		tail = null;
	}
}

