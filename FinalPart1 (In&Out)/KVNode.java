/**
  	Linked node with data that references next nodes, holds key and value.
 
	@author Lutfi Haji-Cheteh
 */
public class KVNode<K extends Comparable<K>, V> implements Comparable<KVNode<K,V>>{
	
	private K key;
	private V value;
	private KVNode<K, V> next;

	public KVNode(){
		next = null;
		key = null;
		value = null;
	}
	
	public KVNode(K newKey, V newValue){
		next = null;
		key = newKey;
		value = newValue;
	}
	
	public void setKey(K newKey){
		key = newKey;
	}
	
	public K getKey(){
		return key;
	}
	
	public void setValue(V newValue){
		value = newValue;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setNext(KVNode<K, V> nextNode){
		next = nextNode;
	}
	
	public KVNode<K, V> getNext(){
		return next;
	}
	
	public int compareTo(KVNode<K, V> other){
		return key.compareTo(other.getKey());
	}
}
