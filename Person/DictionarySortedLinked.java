/**
  	An implementation of Dictionary using sorted linked nodes.
 
	@author Lutfi Haji-Cheteh
 */
import java.util.ArrayList;
import java.util.Iterator;

public class DictionarySortedLinked<K extends Comparable<K>, V> implements DictionaryInterface<K, V>{

	private int numOfNodes;
	private KVNode<K, V> head;
	private KVNode<K, V> tail;
	
	public DictionarySortedLinked(){
		head = null;
		tail = null;
		numOfNodes = 0;
	}
	
	public V add(K key, V value){	
		
		if (contains(key)){
			V tempVal = null;
			KVNode<K, V> thisNode = tail;
			
			while (thisNode != null){
				if (thisNode.getKey().equals(key)){
					tempVal = thisNode.getValue();
					thisNode.setValue(value);
				}
				thisNode = thisNode.getNext();
			}
			return tempVal;
		}
		
		else{
			KVNode<K, V> newNode = new KVNode<K, V>(key, value);
			if (isEmpty()){
				head = newNode;
				tail = newNode;
			}
			
			else if (numOfNodes == 1){
				if (key.compareTo(tail.getKey()) < 0){
					newNode.setNext(tail);
					tail = newNode;
				}
				
				else{
					head.setNext(newNode);
					head = newNode;
				}
			}
			
			else{
				KVNode<K, V> thisNode = tail;
				
				if (key.compareTo(tail.getKey()) < 0){
					newNode.setNext(tail);
					tail = newNode;
					numOfNodes++;
					return null;
				}
				
				while (thisNode.getNext() != null && key.compareTo(thisNode.getKey()) > 0){
					thisNode = thisNode.getNext();
				}
				
				if (thisNode.getNext() == null && key.compareTo(thisNode.getKey()) > 0){
					thisNode.setNext(newNode);
					head = newNode;
				}
				
				else{
					KVNode<K, V> infrontNode = tail;
					
					while (infrontNode.getNext() != thisNode){
						infrontNode = infrontNode.getNext();
					}
					newNode.setNext(thisNode);
					infrontNode.setNext(newNode);
				}
			}
			numOfNodes++;
			return null;
		}
	}
	
	public V remove(K key){
		
		if (contains(key)){
			V tempVal = getValue(key);
			
			if (numOfNodes == 1){
				tail.setValue(null);
				tail.setKey(null);
				head = null;
				tail = null;
			}
			
			else if (numOfNodes == 2){
				if (tail.getKey().equals(key)){
					tail.setValue(null);
					tail.setKey(null);
					tail.setNext(null);
					tail = head;
				}
				
				else{
					head.setValue(null);
					head.setKey(null);
					tail.setNext(null);
					head = tail;
				}
			}
			
			else{
				KVNode<K, V> infrontNode = tail;
				KVNode<K, V> currentNode = tail.getNext();
				
				while (currentNode.getNext() != null && !currentNode.getKey().equals(key)){
					infrontNode = infrontNode.getNext();
					currentNode = currentNode.getNext();
				}
				
				if (currentNode == head){
					currentNode.setValue(null);
					currentNode.setKey(null);
					infrontNode.setNext(null);
					head = infrontNode;
				}
				
				else{
					currentNode.setValue(null);
					currentNode.setKey(null);
					infrontNode.setNext(currentNode.getNext());
					currentNode.setNext(null);
				}
			}
			numOfNodes--;
			return tempVal;
		}
		
		else{
			return null;
		}
	}
	
	public V getValue(K key){
		V tempVal = null;
		KVNode<K, V> thisNode = tail;
		
		while (thisNode != null){
			if (thisNode.getKey().equals(key)){
				tempVal = thisNode.getValue();
			}
			thisNode = thisNode.getNext();
		}
		return tempVal;
	}
	
	public boolean contains(K key){
		boolean contains = false;
		KVNode<K, V> thisNode = tail;
		
		while (thisNode != null){
			if (thisNode.getKey().equals(key)){
				contains = true;
			}
			thisNode = thisNode.getNext();
		}
		return contains;
	}
	
	public Iterator<K> getKeyIterator(){
		ArrayList<K> list = new ArrayList<K>();
		KVNode<K, V> thisNode = tail;
		
		do{
			list.add(thisNode.getKey());
			thisNode = thisNode.getNext();
		}while (thisNode.getNext() != null);
		return list.iterator();
	}
	
	public Iterator<V> getValueIterator(){
		ArrayList<V> list = new ArrayList<V>();
		KVNode<K, V> thisNode = tail;
		
		do{
			list.add(thisNode.getValue());
			thisNode = thisNode.getNext();
		}while (thisNode.getNext() != null);
		return list.iterator();
	}
	
	public boolean isEmpty(){
		return numOfNodes == 0;
	}
	
	public int getSize(){
		return numOfNodes;
	}
	
	public void clear(){
		if (!isEmpty()){
			KVNode<K, V> lastNode = tail;
			
			while (lastNode.getNext() != null){
				lastNode.setKey(null);
				lastNode.setValue(null);
				KVNode<K, V> nextNode = lastNode.getNext();
				lastNode.setNext(null);
				lastNode = nextNode;
			}
			head.setKey(null);
			head.setValue(null);
			head.setNext(null);
			head = null;
			tail = null;
			numOfNodes = 0;
		}
	}
	
}

