package code;

import utils.TreeNode;

/**
 * 面试题26：树的子结构
 * leetcode：572
 * @author Leon Song
 *
 */
public class NO26_SubstructureInTreeTest {
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
		
		TreeNode s1=new TreeNode(2);
		TreeNode s2=new TreeNode(4);
		TreeNode s3=new TreeNode(5);
		s1.left=s2;
		s1.right=s3;
		
//		System.out.println("tree 1");
//		t1.printNode();
//		System.out.println("tree 2");
//		s5.printNode();
		//
		System.out.println(isSubtree(t1, s1));
	}
	public static boolean isSubtree(TreeNode s,TreeNode t) {
		if (s==null||t==null) {
			return false;
		}
		if (isSub(s, t)) {
			return true;
		} else {
			return isSubtree(s.left, t)||isSubtree(s.right, t);
		}
	}
	/*
	 * 判断是否是子树
	 */
	public static boolean isSub(TreeNode s,TreeNode t) {
		if (s==null&&t==null) {
			return true;
		} else if (s==null||t==null) {
			return false;
		}
		if (s.val==t.val) {
			return isSub(s.left, t.left)&&isSub(s.right, t.right);
		} else {
			return false;
		}
	}
	/*
	 * 判断是否是树中的一部分
	 */
	public static boolean isPart(TreeNode s,TreeNode t) {
		if (t==null) {
			return true;
		} else if (s==null) {
			return false;
		}
		
		if (s.val==t.val) {
			return isPart(s.left, t.left)&&isPart(s.right, t.right);
		} else {
			return false;
		}
	}
}
