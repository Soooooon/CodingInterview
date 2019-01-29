package code;

import utils.TreeNode;

/**
 * 面试题28：对称的二叉树
 * leetcode:101
 * @author Leon Song
 *
 */
public class NO28_SymmetricalBinaryTreeTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(2);
		TreeNode t4=new TreeNode(3);
		TreeNode t5=new TreeNode(4);
		TreeNode t6=new TreeNode(4);
		TreeNode t7=new TreeNode(3);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t1.printNode();
		//
		System.out.println(isSymmetric(t1));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		return dfs(root, root);
	}
	public static boolean dfs(TreeNode root1,TreeNode root2) {
		if (root1==null&&root2==null) {
			return true;
		} else if (root1==null||root2==null) {
			return false;
		}
		
		if (root1==root2) {
			return dfs(root1.left, root2.right);
		} else if (root1.val==root2.val) {
			return dfs(root1.left, root2.right)&&dfs(root1.right, root2.left);
		} else {
			return false;
		}
	}
}
