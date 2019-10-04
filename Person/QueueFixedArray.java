/**
  	Data Structure Queue implemented with fixed sized array
 
	@author Lutfi Haji-Cheteh
	(added getSize to use in In-N-Out class.)
	(added toArray for Person class.)
 */
public class QueueFixedArray<T> implements QueueInterface<T>{
	
	private static final int MAX_CAPACITY = 10;
	private final T[] queue;
	private int front;
	private int back;
	private int numOfItems;
	
	public QueueFixedArray(){
		this(MAX_CAPACITY);
	}
	
	public QueueFixedArray(int size){
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[])new Object[size];
		queue = tempQueue;
		front = 0;
		back = 0;
		numOfItems = 0;
	}
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		back = (back % MAX_CAPACITY);
		queue[back] = newEntry;
		numOfItems++;
		back++;
	}
	
	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		else{
			front = (front % MAX_CAPACITY);
			T tempItem = queue[front];
			queue[front] = null;
			numOfItems--;
			front++;
			return tempItem;
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
			return queue[front];
		}
	}
	
	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		if (front == back){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		for (int i=0; i<MAX_CAPACITY; i++){
			queue[i] = null;
		}
		front = 0;
		back = 0;
	}
	
	public int getSize(){
		return numOfItems;
	}
	
	public T[] toArray(){
		   return queue;
	   }
}