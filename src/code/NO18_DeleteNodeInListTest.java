package code;
/**
 * 面试题18：删除链表的节点
 * leetcode：237,83,82
 * @author Soon
 *
 */

import utils.LinkList;
import utils.ListNode;

public class NO18_DeleteNodeInListTest {
	public static void main(String[] args) {
		//
		LinkList lt=new LinkList(new ListNode(1));
		lt.insertTail(new ListNode(2));
		lt.insertTail(new ListNode(2));
//		lt.insertTail(new ListNode(3));
//		lt.insertTail(new ListNode(4));
//		lt.insertTail(new ListNode(4));
//		lt.insertTail(new ListNode(5));
		lt.printLinkListOrderly();
		//
//		deleteDuplicates(lt.head);
//		lt.printLinkListOrderly();
		new LinkList(deleteDuplicatesIncludeSelf(lt.head)).printLinkListOrderly();
	}
	/**
	 * 题目二：删除链表中重复的节点
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode cur=head;
		while(cur!=null&&cur.next!=null) {
			if (cur.val==cur.next.val) {
				ListNode dup=cur.next;
				while(dup.next!=null&&dup.val==dup.next.val) {
					dup=dup.next;
				}
				cur.next=dup.next;
			}
			cur=cur.next;
		}
		return head;
	}
	/**
	 * 删除链表中重复元素（包括自己）
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicatesIncludeSelf(ListNode head) {
		while(head!=null&&head.next!=null&&head.val==head.next.val) {
			while(head.next!=null&&head.val==head.next.val) {
				head=head.next;
			}
			head=head.next;	
		}
		ListNode cur=head;
		ListNode dup;
		while(cur!=null&&cur.next!=null) {
			dup=cur.next;
			while(dup!=null&&dup.next!=null&&dup.val==dup.next.val) {
				while(dup.next!=null&&dup.val==dup.next.val) {
					dup=dup.next;
				}
				dup=dup.next;
			}
			cur.next=dup;
			cur=cur.next;
		}
		return head;
	}
	
}
