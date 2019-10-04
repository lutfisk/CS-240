/**
  	A double linked node with data that references next and previous nodes.
 
	@author Lutfi Haji-Cheteh
 */
public class DoubleNode<T>{
	
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	
	public DoubleNode(){
		data = null;
		next = null;
		prev = null;
	}
	
	public DoubleNode(T newData){
		data = newData;
		next = null;
		prev = null;
	}
	
	public void setData(T newData){
		data = newData;
	}
	
	public T getData(){
		return data;
	}
	
	public void setNext(DoubleNode<T> nextNode){
		next = nextNode;
	}
	
	public DoubleNode<T> getNext(){
		return next;
	}
	
	public void setPrev(DoubleNode<T> prevNode){
		prev = prevNode;
	}
	
	public DoubleNode<T> getPrev(){
		return prev;
	}
	
}

