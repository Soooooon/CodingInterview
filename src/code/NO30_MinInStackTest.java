package code;

import java.util.Stack;
/**
 * 面试题30：包含min函数的栈
 * leetcode：155
 * @author Leon Song
 *
 */
public class NO30_MinInStackTest {
	public static void main(String[] args) {
		
		MinStack minStack=new MinStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}
	
	
}

class MinStack{
	public Stack<Integer> st;
	public Stack<Integer> min;
	
	public MinStack() {
		// TODO Auto-generated constructor stub
		this.st=new Stack<>();
		this.min=new Stack<>();
	}
	
	public void push(int x) {
		st.push(x);
		if (min.isEmpty()||x<=min.peek()) {
			min.push(x);
		}
	}
	
	public void pop() {
		int x=st.pop();
		if (min.peek()==x) {
			min.pop();
		}
	}
	
	public int top() {
		return st.peek();
	}
	
	public int getMin() {
		return min.peek();
	}
}