/**
  	An object with data and reference to the next Node
 
	@author Lutfi Haji-Cheteh
 
 */

public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	public Node(){
		data = null;
		next = null;
	}
	
	public Node(T info, Node<T> nextNode){
		data = info;
		next = nextNode;
	}
	
	public T getData(){
		return data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setData(T info){
		data = info;
	}
	
	public void setNext(Node<T> nextNode){
		next = nextNode;
	}

}
