package code;

import utils.TreeNode;

public class NO55_01_TreeDepthTest {
	public static void main(String[] args) {
		//
		
		//
		
	}
	public static int maxDepth(TreeNode root) {
		if (root==null) {
			return 0;
		}
		int leftDepth=maxDepth(root.left);
		int rightDepth=maxDepth(root.right);
		return Math.max(leftDepth, rightDepth)+1;
	}
}
