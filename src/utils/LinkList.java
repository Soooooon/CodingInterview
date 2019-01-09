package utils;

public class LinkList {
	public ListNode head;
	public LinkList(ListNode head) {
		this.head=head;
	}
	
	public void insertTail(ListNode node) {
		ListNode cur=head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		cur.next=node;
	}
	
	public void printLinkListOrderly() {
		ListNode cur=head;
		System.out.println("链表头：");
		while(cur!=null) {
			System.out.println(cur.val);
			cur=cur.next;
		}
		System.out.println("打印完毕！");
	}

}
