/**
  	Data Structure Queue implemented with circular linked data
 
	@author Lutfi Haji-Cheteh
 
 */
public class QueueCircularLD<T> implements QueueInterface<T>{

	private int numberOfNodes;
	private Node<T> free;
	private Node<T> tail;
	
	public QueueCircularLD(){
		Node<T> emptyNode = new Node<T>();
		emptyNode.setNext(emptyNode);
		numberOfNodes = 0;
		free = emptyNode;
		tail = null;
	}
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		if (isEmpty()){
			Node<T> newNode = new Node<T>(newEntry, free);
			tail = newNode;
			free.setNext(tail);
		}
		else{
			Node<T> newNode = new Node<T>(newEntry, tail);
			tail = newNode;
			free.setNext(tail);
		}
		numberOfNodes++;
	}
	
	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		/*else{
			Node<T> secondNode = tail.getNext();
			while (
		}*/
	}
	
	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		/*else{
			Node<T> secondNode = tail.getNext();
			while (
		}*/
	}
	
	/** Detects whether this queue is empty.
    @return  True if the queue is free, or false otherwise. */
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
		
	}
}