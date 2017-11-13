package QueuePrior;

public class QueuePrior<T> implements Cloneable {
	private int size;
	private static class Node<T> implements Cloneable{
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
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
			Node prevNode = value;
			this.value.next = node;
			value = node;
			value.prev = prevNode;
		}
		size++;
		
	}
	public T pop(){
		if(isEmpty()){
		System.out.println("Queue is empty!");
		return null;
		}
		Node<T> node = first;
		first = first.next;
		size--;
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
	public QueuePrior clone() throws CloneNotSupportedException{
		Node<T> firstSave = this.first;
		QueuePrior l = new QueuePrior<T>();
		while(!(isEmpty())){
			l.push(pop());
		}
		this.first = firstSave;
		
		return l;
	}
	public int size(){
		return size;
	}
	
	
	
	
}
