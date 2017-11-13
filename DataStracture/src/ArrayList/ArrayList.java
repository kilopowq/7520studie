package ArrayList;

import LinkedListOne.LinkedListOne;

public class ArrayList<T> implements Cloneable{
	private int size = 0 ;
	private T [] array;
		
		public ArrayList(){
			array = (T[]) new Object[10];
		}
		public ArrayList(int length){
			array = (T[]) new Object[length];
		}
	public int size(){
		return size;
	}
		
	public void ensureCapasity(){
			T[]arrayNew = (T[])new Object[size*2];
			System.arraycopy(array,0, arrayNew, 0, size);
			array = arrayNew;
		
	}
	
	public boolean add(T val){
		if(array.length <= size){
			ensureCapasity();
		}
		array[size++] = val;
		
		return true;
		
	}
	public T get(int index){
		if(index < size && index >= 0){
			return array[index];
		}
		else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
	public boolean add(T val,int index){
		if(index < 0){
			return false;
		}
		if(size+1 >= array.length){
			ensureCapasity();
		}
		if(index >= size){
			array[size++] = val;
			return true;
		}
		if(index < size){
		rewriteAddIndex(index,val);
		size++;
		}
		return true;
	}
	public void rewriteAddIndex(int index,T val){
		T[]arrayNew = (T[])new Object[array.length];
		if(index == 0){
			arrayNew[index] = val;
			System.arraycopy(array,0, arrayNew, 1, size+1);
			array = arrayNew;
			
		}else{
			arrayNew[index] = val;
			System.arraycopy(array,0, arrayNew, 0, index);
			System.arraycopy(array,index, arrayNew, index+1, size-index);
			array = arrayNew;
		}
		
	}
	public T remove(int index){
		T elem = null;
		T[]arrayNew = (T[])new Object[array.length];
		if(index >=0 && index < size){
			if(index == 0|| index == size-1){
				if(index == 0){
				elem = array[index];
				System.arraycopy(array,1, arrayNew, 0, size);
				array = arrayNew;
				size--;
				return elem;
				}
				else{
					
					elem = array[index];
					System.arraycopy(array,0, arrayNew, 0, size-1);
					array = arrayNew;
					size--;
					return elem;
					}
			}
			else{
						elem = array[index];
						array[index] = null;
						System.arraycopy(array,0, arrayNew,0,index);
						System.arraycopy(array,index+1, arrayNew, index, size-index);
						array = arrayNew;
						size--;
						return elem;
					
				
			}
			
		
		}else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		
	}
	@Override
	public String toString(){
		StringBuilder listBuilder = new StringBuilder();
		if(array !=null){
		for(int i = 0;i < size;i++){
			listBuilder.append(array[i]).append(",");
		}
		}
		String list = "";
        if(listBuilder.lastIndexOf(",")>0){
        	list = listBuilder.toString().substring(0, listBuilder.length()-1);
        }else{
        	list = listBuilder.substring(0);
        }
        return "ArrayList [" + list+ "]";
	}
	public int indexOf(T val){
		for(int i = 0; i < size ; i++){
			if(val.equals(array[i])){
				return i;
				
			}
		}
		return -1;
	}
	public void set(T val,int index){
		if(index >= 0 && index < size){
			array[index] = val;
		}
		else throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
	public ArrayList<T> subList(int start,int end){
		
		if(start >= 0 && end < size){
			ArrayList<T> ar = new ArrayList<T>();
			
		for(int i = 0; i < size;i++){
				if(i >= start && i <= end){
					ar.add(array[i]);		
				}
			}
		
		return ar;
		}else throw new IndexOutOfBoundsException("Index start: "+start+" Index end: "+end+", Size: "+size);
		
	}
	public int lastIndexOf(T val){
		for(int i=size-1;i >=0;i--){
			if(val.equals(array[i])){
				return i;
			}
		}
		return -1;
	}
	public ArrayList clone(){

		ArrayList<T> list = new ArrayList<T>();
		for(int i = 0;i < size;i++){
			list.add(array[i]);
		}
		return list;
		
	}
	public void clear(){
		array = (T[]) new Object[10];
		size = 0;
	}
	
	
	
}
