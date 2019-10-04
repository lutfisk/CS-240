/**
  	A single linked node with data that references next and previous nodes.
 
	@author Lutfi Haji-Cheteh
 */
public class SingleNode<T>{
	
	private T data;
	private SingleNode<T> prev;
	
	public SingleNode(){
		data = null;
		prev = null;
	}
	
	public SingleNode(T newData){
		data = newData;
		prev = null;
	}
	
	public void setData(T newData){
		data = newData;
	}
	
	public T getData(){
		return data;
	}
	
	public void setPrev(SingleNode<T> prevNode){
		prev = prevNode;
	}
	
	public SingleNode<T> getPrev(){
		return prev;
	}
	
}

