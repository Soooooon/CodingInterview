package code;
/**
 * 面试题22：链表中倒数第k个节点
 * leetcode：19
 * @author Leon Song
 *
 */

import utils.LinkList;
import utils.ListNode;

public class NO22_KthNodeFromEndTest {
	public static void main(String[] args) {
		//
		LinkList l1=new LinkList(new ListNode(1));
		l1.insertTail(new ListNode(2));
		l1.insertTail(new ListNode(3));
		l1.insertTail(new ListNode(4));
		l1.insertTail(new ListNode(5));
		l1.insertTail(new ListNode(6));
		l1.printLinkListOrderly();
		//
		System.out.println(findKthToTail(l1.head, 0));
	}
	public static ListNode findKthToTail(ListNode head,int k) {
		ListNode ans=null;
		ListNode cur=head;
		int count=1;
		while(cur!=null&&count<k) {
			cur=cur.next;
			count++;
		}
		if (cur==null||k<=0) {
			return ans;
		}
		ans=head;
		while(cur.next!=null) {
			cur=cur.next;
			ans=ans.next;
		}
		return ans;
	}
}
