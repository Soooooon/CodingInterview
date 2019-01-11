package code;
/**
 * 面试题9：用两个栈实现队列
 */
import java.util.Stack;

public class NO9_QueueWithTwoStacksTest {
	public static void main(String[] args) {
		
	}
	public class QueueWithTwoStacks{
		Stack<Integer> stack1=new Stack<>();
		Stack<Integer> stack2=new Stack<>();
		
		public void push(int node) {
			stack1.push(node);
		}
		
		public int pop() {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int ans=stack2.pop();
			while(!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return ans;
		}
		
	}
}
