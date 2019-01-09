package code;
/**
 * 面试题6：从尾到头打印链表
 * leetcode无此题
 */
import java.util.ArrayList;
import java.util.Stack;

import utils.LinkList;
import utils.ListNode;

public class NO6_PrintListFromTailToHeadTest {
	public static void main(String[] args) {
		//
		LinkList lt=new LinkList(new ListNode(1));
		lt.insertTail(new ListNode(2));
		lt.insertTail(new ListNode(3));
		lt.printLinkListOrderly();
		//
		System.out.println(printListFromTailToHead_method2(lt.head).toString());
		
	}
	
	/**
	 * 采用辅助栈
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead_method1(ListNode listNode) {
		Stack<Integer> st=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<>();
		while(listNode!=null) {
			st.push(listNode.val);
			listNode=listNode.next;
		}
		while(!st.isEmpty()) {
			ans.add(st.pop());
		}
		return ans;
	}
	/**
	 * 采用递归调用的形式，不用辅助栈
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead_method2(ListNode listNode){
		ArrayList<Integer> ans=new ArrayList<>();
		solve(listNode, ans);
		return ans;
	}
	public static void solve(ListNode listNode,ArrayList<Integer> ans) {
		if (listNode!=null) {
			solve(listNode.next, ans);
			ans.add(listNode.val);
		}
	}
	
}
