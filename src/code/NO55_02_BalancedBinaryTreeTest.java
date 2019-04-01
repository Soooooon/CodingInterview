	package code;

import utils.TreeNode;

public class NO55_02_BalancedBinaryTreeTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t5.left=t7;
		t3.right=t6;
		
		//
		System.out.println(isBalancedTree(t1));
		
	}
	public static boolean flag;
	public static boolean isBalancedTree(TreeNode root) {
		flag=true;
		depth(root);
		return flag;
	}
	public static int depth(TreeNode root) {
		if (root==null) {
			return 0;
		}
		
		
		int leftDepth=depth(root.left);
		int rightDepth=depth(root.right);
		
		if (Math.abs(leftDepth-rightDepth)>1) {
			flag=false;
		}
		
		return Math.max(leftDepth, rightDepth)+1;
	}
}
