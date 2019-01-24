package code;
/**
 * 面试题23：链表中环的入口节点
 * leetcode：无
 * @author Leon Song
 *
 */

import utils.ListNode;

public class NO23_EntryNodeInlistLoopTest {
	public static void main(String[] args) {
		//
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		ListNode n6=new ListNode(6);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n3;
		//
		System.out.println(entryNodeOfLoop(head).val);
	}
	public static ListNode entryNodeOfLoop(ListNode pHead) {
		if (meetingNode(pHead)==null) {
			return null;
		}
		ListNode meetNode=meetingNode(pHead);
		ListNode cur=meetNode.next;
		int k=1;
		while(cur!=meetNode) {
			cur=cur.next;
			k++;
		}
		
		cur=pHead;
		ListNode ans=pHead;
		while(k>0) {
			cur=cur.next;
			k--;
		}
		while(cur!=ans) {
			cur=cur.next;
			ans=ans.next;
		}
		return ans;
	}
	
	public static ListNode meetingNode(ListNode head) {		
		if (head==null) {
			return null;
		}
		ListNode slow=head;
		ListNode fast=head.next;
		
		while(fast!=null) {
			if (fast==slow) {
				return fast;
			}
			
			slow=slow.next;
			fast=fast.next;
			if (fast.next!=null) {
				fast=fast.next;
			}
		}
		return null;
	}
}
