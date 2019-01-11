package utils;

public class TreeLinkNode {
	public int val;
	public TreeLinkNode left = null;
	public TreeLinkNode right = null;
	public TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
    
    public static TreeLinkNode aCase() {
    	TreeLinkNode node8=new TreeLinkNode(8);
    	TreeLinkNode node9=new TreeLinkNode(9);
    	TreeLinkNode node5=new TreeLinkNode(5);
		node5.left=node8;
		node5.right=node9;
		node8.next=node5;
		node9.next=node5;
		
		TreeLinkNode node4=new TreeLinkNode(4);
		TreeLinkNode node2=new TreeLinkNode(2);
		node2.left=node4;
		node2.right=node5;
		node4.next=node2;
		node5.next=node2;
		
		TreeLinkNode node6=new TreeLinkNode(6);
		TreeLinkNode node7=new TreeLinkNode(7);
		TreeLinkNode node3=new TreeLinkNode(3);
		node3.left=node6;
		node3.right=node7;
		node6.next=node3;
		node7.next=node3;
		
		TreeLinkNode node1=new TreeLinkNode(1);
		node1.left=node2;
		node1.right=node3;
		node2.next=node1;
		node3.next=node1;
		
		return node1;
	}
    
    public void printNode() {
		String leftInfor;
		String rightInfor;
		
		if (left!=null) {
			leftInfor=String.valueOf(left.val);
		} else {
			leftInfor="*";
		}
		if (right!=null) {
			rightInfor=String.valueOf(right.val);
		} else {
			rightInfor="*";
		}
		System.out.println("*******");
		System.out.println("   "+val+"   ");
		System.out.println("  / \\    ");
		System.out.println(" "+leftInfor+"   "+rightInfor+" ");
		System.out.println("*******");
		
		if (this.left!=null) {
			this.left.printNode();			
		}
		if (this.right!=null) {
			this.right.printNode();
		}
	}
}
