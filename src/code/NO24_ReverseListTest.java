package code;

import utils.LinkList;
import utils.ListNode;

/**
 * 面试题24：反转链表
 * leetcode：206
 * @author Leon Song
 *
 */
public class NO24_ReverseListTest {
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
		new LinkList(reverseList(l1.head)).printLinkListOrderly();;
	}
	public static ListNode reverseList(ListNode head) {
		if (head==null||head.next==null) {
			return head;
		}
		
		ListNode reHead=reverseList(head.next);
        head.next.next=head;//将指向反转
        head.next=null;
        return reHead;
	}
	
}
