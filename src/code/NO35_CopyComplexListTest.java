package code;
/**
 * 面试题35：复杂链表的复制
 * leetcode:138
 * @author Leon Song
 *
 */
public class NO35_CopyComplexListTest {
	public static void main(String[] args) {
		//
//		Node n1=new Node(1,null,null);
//		Node n2=new Node(2,null,null);
//		Node n3=new Node(3,null,null);
//		Node n4=new Node(4,null,null);
//		Node n5=new Node(5,null,null);
//		n1.next=n2;
//		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
//		n1.random=n3;
//		n2.random=n5;
//		n4.random=n2;
		
		Node n1=new Node(1,null,null);
		Node n2=new Node(2,null,null);
		n1.next=n2;
		n1.random=n2;
		n2.random=n2;
		//
//		cloneList(n1);
//		connectRandom(n1);
//		n1.printNode();
		
		Node ans=copyRandomList(n1);
		ans.printNode();
	}
	public static Node copyRandomList(Node head) {
		cloneList(head);
		connectRandom(head);
		return splitEven(head);
	}
	
	public static void cloneList(Node head) {
		if (head==null) {
			return;
		}
		
		Node cloneHead=new Node(head.val,head.next,null);
		cloneHead.next=head.next;
		head.next=cloneHead;
		cloneList(cloneHead.next);
	}
	public static void connectRandom(Node head) {
		if (head==null) {
			return;
		}
		if (head.random!=null) {
			head.next.random=head.random.next;
		}
		connectRandom(head.next.next);
	}
	public static Node splitEven(Node head) {
		if (head==null) {
			return null;
		}
		Node ans=head.next;
		Node cur=head;
		Node cloneCur=head.next;
		
		while(cur.next.next!=null) {
			cur.next=cloneCur.next;
			cur=cur.next;
			
			cloneCur.next=cur.next;
			cloneCur=cloneCur.next;
		}
		return ans;
	}
	
}


class Node{
	public int val;
	public Node next;
	public Node random;
	
	public Node() {}
	
	public Node(int val,Node next,Node random) {
		this.val=val;
		this.next=next;
		this.random=random;
	}
	
	public void printNode() {
		System.out.println(this);
		System.out.println("val:"+val);
		System.out.println("next.val:"+(next==null?"null":next.val));
		System.out.println("random.val:"+(random==null?"null":random.val));
		System.out.println("****************");
		if (this.next!=null) {
			this.next.printNode();			
		}
	}
}
