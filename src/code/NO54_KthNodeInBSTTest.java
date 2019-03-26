package code;

import utils.TreeNode;

public class NO54_KthNodeInBSTTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(5);
		TreeNode t2=new TreeNode(3);
		TreeNode t3=new TreeNode(7);
		TreeNode t4=new TreeNode(2);
		TreeNode t5=new TreeNode(4);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(8);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		
//		t1.printNode();
		//
		System.out.println(kthSmallest(t1, 3));
	}
	public static int count=0;
	public static int ans=0;
	public static int kthSmallest(TreeNode root,int k) {
		dfs(root, k);
		return ans;
	}
	public static void dfs(TreeNode root,int k) {
		if (count>k) {
			return;
		}
		if (root==null) {
			return;
		}
		dfs(root.left, k);
		count++;
		if (count==k) {
			ans=root.val;
			return;
		} 
		dfs(root.right, k);
	}
}
