package LinkedListOne;

import LinkedListPrior.LinkedListPrior;

public class LinkedListOne<T> implements Cloneable{
	private int size;
	private static class Node<T> implements Cloneable{
		private T data;
		private Node<T> next;
		
		
			public Node(T data){
				this.data = data;
			}
			@Override
			public String toString() {
	            return data.toString();
	        }
	}
	private Node<T> value = null;
	private Node<T> first = null;
	
	public boolean isEmpty(){
		
			return value == null ;
			
		}
	
	public int size(){
		return this.size;
	}
	
	public void add(T val){
		Node<T> node = new Node(val);
		if(isEmpty()){
			value = node;
			first = node;
			size++;
		}
		else{
			value.next = node;
			value = node;
			size++;
		}
	}

	public void add(T val,int index){
		Node<T> node = null;
		Node<T> newN = null;
		if(index >= 0){
		
			node = new Node(val);
			newN = first;
			if(index < size){
				if(isEmpty()){
				value = node;
				first = node;
				size++;
				}
				else{
					if(index == 0){
						node.next = newN;
						this.first = node;
					}
					else{
					for(int i = 0;i < index-1; i++){
						newN = newN.next;
							}
						node.next = newN.next;
						newN.next = node;
						}
					}
				size++;
			}	
			else{
				if(isEmpty()){
				value = node;
				first = node;
				size++;
				}
				else{
				value.next = node;
				Node<T> n = value;
				value = node;
				size++;
				}
			}
		}else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
	@Override
	public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(",");
            currentNode = currentNode.next;
        }
        String list = "";
        if(listBuilder.lastIndexOf(",")>0){
        	list = listBuilder.toString().substring(0, listBuilder.length()-1);
        }else{
        	list = listBuilder.substring(0);
        }
        
        return "LinkedListOne [" + list+ "]";
    }
	public T get(int index){
		
		Node<T> newN = first;
		if(index >=0 && index < size){
			for(int i = 0;i < index; i++){
				newN = newN.next;
			}
			
		}
		else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		return newN.data;
		}
	public int indexOf(T obj){
		
		int index = 0;
	    Node current = first;

	    while (current != null) {
	        if (current.data.equals(obj)) {
	            return index;
	        }
	        index++;
	        current = current.next;
	    }

	    return -1;
	}
	
	public <T> T [] tuarei(){
		T []array =  (T[])new Object[size];
		for(int i = 0; i < size;i++){
			array[i] = (T) get(i);
		}
		return array;
	}
	public LinkedListOne clone(){

		LinkedListOne<T> list = new LinkedListOne<T>();
		for(int i=0;i < size;i++){
			list.add(get(i));
		}
		return list;
		
	}
	public boolean remove(int index){
		if(index >= 0 && index < size){
			if(index == 0){
				first = first.next;
				size--;
			}
			else{
				Node<T> remNode = first;
				for(int i = 1;i < index;i++){
					remNode = remNode.next;
				}
				remNode.next = remNode.next.next;
				size--;
			}
			return true;
			
		}
		else {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		
	}
	
}
