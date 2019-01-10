package code;
/**
 * 面试题7：重构二叉树
 * leetcode无此题
 * @author Leon Song
 *
 */

import utils.TreeNode;

public class NO7_ReconstructBinaryTreeTest {
	public static void main(String[] args) {
		//
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		//
		reconstructBinaryTree(pre, in).printNode();;
	}
	/**
	 * 采用递归方式，分别构造左子树和右子树
	 * @param pre
	 * @param in
	 * @return
	 */
	public static TreeNode reconstructBinaryTree(int[] pre,int[] in) {
		return solve(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	public static TreeNode solve(int[] pre,int[] in,int preLow,int preHigh,int inLow,int inHigh) {
		if (preLow>preHigh||inLow>inHigh) {
			return null;
		}
		TreeNode root=new TreeNode(pre[preLow]);
		if (preLow==preHigh) {
			return root;
		}
		int count=0;
		for (int i = inLow; i <= inHigh; i++) {
			if (in[i]==pre[preLow]) {
				break;
			}
			count++;
		}
		root.left=solve(pre, in, preLow+1, preLow+count, inLow, inLow+count-1);
		root.right=solve(pre, in, preLow+count+1, preHigh, inLow+count+1, inHigh);
		return root;
	}
}
