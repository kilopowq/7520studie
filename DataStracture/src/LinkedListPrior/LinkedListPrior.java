
package LinkedListPrior;



public class LinkedListPrior<T> {
	private int size;
	private static class Node<T> implements Cloneable{
		private T data;
		private Node<T> next;
		private Node<T> perv;
		
		
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
	public void add(T val){
		Node<T> node = new Node(val);
		if(isEmpty()){
			value = node;
			first = node;
			size++;
		}
		else{
			value.next = node;
			Node<T> n = value;
			value = node;
			value.perv = n;
			size++;
		}
	}
	
	public void add(T val,int index){
		if(index >= 0){
		
		Node<T> node = new Node(val);
		Node<T> newN = first;
		Node<T> newL = value;
		if(index < size){
			if(isEmpty()){
				value = node;
				first = node;
				size++;
			}
			else{
				if(index == 0){
					node.perv = newN.perv;
					newN.perv = node;
					node.next = newN;
					this.first = node;
				}
				else{
					
					if(index >(size/2)){
						for(int i = size-1;i > index; i--){
							newL = newL.perv;
						}
						node.perv = newL.perv;
						newL.perv = node;
						node.next = newL;
						Node pervNode = node.perv;
						pervNode.next = node;
						
						size++;
					}
					else{
						for(int i = 0;i < index; i++){
							newN = newN.next;
						}
						node.perv = newN.perv;
						newN.perv = node;
						node.next = newN;
						Node pervNode = node.perv;
						pervNode.next = node;
						
						size++;
					}
				}	
			
			}
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
				value.perv = n;
				size++;
			}
		}
	}else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		
	}
	public T get(int index){
		if((size/2)<index){
			Node<T> newN = value;
			if(index >=0 && index < size){
				for(int i = (size-1);i > index; i--){
					newN = newN.perv;
				}
				
			}else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
			return newN.data;
		}
		else{
		Node<T> newN = first;
		if(index >=0 && index < size){
			for(int i = 0;i < index; i++){
				newN = newN.next;
			}
			
		}
		else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		return newN.data;
		}
	}
	public boolean remove(int index){
		if(index >=0 && index < size){
			if((size/2) > index){

				if(index ==0){
					first = first.next;
					first.perv = null;
					size--;
				}
				else{
					Node firstNode = first;
					for(int i = 0;i < index;i++){
						firstNode = firstNode.next;
					}
					firstNode.next.perv = firstNode.perv;
					firstNode.perv.next = firstNode.next;
					
					size--;
				}
			}
			else{
				if(index ==(size-1)){
					value = value.perv;
					value.next = null;
					size--;
				}
				else{
					Node lastNode = value;
					for(int i = size-1;i > index;i--){
						lastNode = lastNode.perv;
					}
					lastNode.next.perv = lastNode.perv;
					lastNode.perv.next = lastNode.next;
					size--;
				}
				
				
			}
		}else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		return false;
	}
	public int indexof(T obj){
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
	
	public LinkedListPrior clone(){

		LinkedListPrior<T> list = new LinkedListPrior<T>();
		for(int i=0;i < size;i++){
			list.add(get(i));
		}
		return list;
		
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
        
        return "LinkedList [" + list+ "]";
    }
	public int size(){
		return this.size;
	}
	public <T> T [] tuarei(){
		T []array =  (T[])new Object[size];
		for(int i = 0; i < size;i++){
			array[i] = (T) get(i);
		}
		return array;
	}

	
}
