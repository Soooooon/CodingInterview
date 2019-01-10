package utils;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val=val;
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
