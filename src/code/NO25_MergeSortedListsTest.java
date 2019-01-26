package code;

import utils.LinkList;
import utils.ListNode;

/**
 * 面试题25：合并两个排序的链表
 * leetcode：21
 * @author Leon Song
 *
 */
public class NO25_MergeSortedListsTest {
	public static void main(String[] args) {
		//
		LinkList l1=new LinkList(new ListNode(1));
		l1.insertTail(new ListNode(3));
		l1.insertTail(new ListNode(5));
		
		LinkList l2=new LinkList(new ListNode(2));
		l2.insertTail(new ListNode(4));
		l2.insertTail(new ListNode(6));
		
		l1.printLinkListOrderly();
		l2.printLinkListOrderly();
		//
		new LinkList(mergeTwoLists(l1.head, l2.head)).printLinkListOrderly();
	}
	
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		if (l1==null) return l2;
		if (l2==null) return l1;
		
		ListNode head=null;
		
		if (l1.val>l2.val) {
			head=l2;
			head.next=mergeTwoLists(l1, l2.next);
		} else {
			head=l1;
			head.next=mergeTwoLists(l1.next, l2);
		}
		
		return head;
	}
}
