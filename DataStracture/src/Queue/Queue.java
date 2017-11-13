package Queue;

public class Queue<T> implements Cloneable {
	
	private LinkedList<T> linkedList = new LinkedList<T>();
private int size;

	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	public void push(T value){
		size++;
		linkedList.push(value);
		
	}
	public T pop(){
		
		if(isEmpty()){
			System.out.println("Queue is empty!");
			return null;
		}
		else{
			size--;
			return linkedList.pop();
		}
		
	}
	public T peek(){
		return linkedList.peek();
	}
	public int size(){
		return size;
	}
	@Override
	public Queue clone() throws CloneNotSupportedException{
		Queue s  = new Queue();
		s.linkedList  = this.linkedList.clone();
		s.size = this.size;
		return s;
	}
	public void clear(){
		this.linkedList.clear();
	}
	public <T> T [] tuarei(){
		return linkedList.tuarei(size);
	}
	@Override
	public String toString() {
		return "Queue [" + linkedList + "]";
	}
}
	class LinkedList<T> implements Cloneable{
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
		private Node<T> first = null;
		private Node<T> value = null;
		
		public boolean isEmpty(){
			return first == null;
		}
		public void push(T data){
			Node<T> node = new Node<T>(data);
			

			if(first == null){
				first = node;
				value = node;
			}
			else{
				this.value.next = node;
				value = node;
			}
			
			
		}
		public T pop(){
			Node<T> node = first;
			first = first.next;
			return node.data;
		}
		public T peek(){
			return first.data;
		}
		public void clear(){
			this.first = null;
			
			
			this.value = null;
		
		}
		public <T>  T [] tuarei(int size){
			T []array =  (T[])new Object[size];
			for(int i = 0; i < size;i++){
				if(!(isEmpty())){
				array[i] = (T) pop();
				}
				else{
					System.out.println("pp");
				}
			}
			return array;
		}
		
		
		
		@Override
	    public String toString() {
	        StringBuilder listBuilder = new StringBuilder();
	        Node currentNode = first;
	        while (currentNode != null) {
	            listBuilder.append(currentNode).append(",");
	            currentNode = currentNode.next;
	        }
	        
	        return listBuilder.toString();
	    }
		@Override
		public LinkedList clone() throws CloneNotSupportedException{
			Node<T> firstSave = this.first;
			LinkedList l = new LinkedList<T>();
			while(!(isEmpty())){
				l.push(pop());
			}
			this.first = firstSave;
			
			return l;
		}
	}

