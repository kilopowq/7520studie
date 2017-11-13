package main;

import Queue.Queue;
import QueuePrior.QueuePrior;
import Stack.Stack;
import ArrayList.ArrayList;
import LinkedListOne.LinkedListOne;
import LinkedListPrior.LinkedListPrior;

public class main {

	public static void main(String[] args) throws CloneNotSupportedException {
	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> st = null;
				//превірити чи стек і черга норм клонує

		Integer i1 = new Integer(10);
		Integer i2 = new Integer(20);
		Integer i3 = new Integer(30);
		Integer i4 = new Integer(8);
		Integer i5 = new Integer(888);
		stack.add(i4);
		stack.add(i5);
		stack.add(i1);
		stack.add(i1);
		stack.add(i3);
		
		
		//st = stack.clone();
		//System.out.println(stack.size());
		//System.out.println(st.size());
		stack.add(i4);
		stack.add(i5);
		System.out.println(stack);
		stack.clear();
		System.out.println(stack);
		
		/*for(int i =0;i < stack.size();i++){
		System.out.print(stack.get(i)+ ",");
		}
		System.out.println();
		for(int i =0;i < st.size();i++){
			System.out.print(st.get(i)+ ",");
			}*/
		

		
	//	System.out.println(st);

		
		
	}

}
