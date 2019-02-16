package code;

import java.util.Stack;

/**
 * 面试题31：栈的压入、弹出序列
 * leetcode:946
 * @author Leon Song
 *
 */
public class NO31_StackPushPopOrderTest {
	public static void main(String[] args) {
		//
		int[] pushed= {1,0};
		int[] popped= {1,0};
		//
		System.out.println(validateStackSequences(pushed, popped));
	}
	
	public static boolean validateStackSequences(int[] pushed,int[] popped) {
		
		Stack<Integer> st=new Stack<>();
		int index=0;
		for (int x:pushed) {
			st.push(x);
			
			while(index<popped.length&&!st.isEmpty()&&st.peek()==popped[index]) {
				index++;
				st.pop();
			}
		}
		
		if (index==popped.length) {
			return true;
		} else {
			return false;
		}
		
	}
}
