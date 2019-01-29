package code;

import java.util.LinkedList;
import java.util.Queue;

import utils.BinaryTree;
import utils.TreeNode;

/**
 * 面试题27：二叉树的镜像
 * leetcode:226
 * @author Leon Song
 *
 */
public class NO27_MirrorOfBinaryTreeTest {
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
		t5.left=t6;
		t5.right=t7;
		//
		new BinaryTree(invertTree_method2(t1)).printAll();
	}
	
	/**
	 * 递归版本
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree_method1(TreeNode root) {
		if (root==null) {
			return null;
		}
		
		root.left=invertTree_method1(root.left);
		root.right=invertTree_method1(root.right);
		
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		return root;
	}
	
	/**
	 * 迭代版本
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree_method2(TreeNode root) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		
		queue.add(root);
		TreeNode node;
		
		while(!queue.isEmpty()) {
			node=queue.poll();
			
			TreeNode temp=node.left;
			node.left=node.right;
			node.right=temp;
			
			if (node.left!=null) {
				queue.add(node.left);				
			}
			if (node.right!=null) {
				queue.add(node.right);				
			}
		}
		
		
		return root;
	}
}
