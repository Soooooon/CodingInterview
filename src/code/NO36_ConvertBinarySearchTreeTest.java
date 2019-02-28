package code;
/**
 * 面试题36：二叉搜索树与双向链表
 * @author Leon Song
 *
 */

import utils.TreeNode;

public class NO36_ConvertBinarySearchTreeTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(10);
		TreeNode t2=new TreeNode(6);
		TreeNode t3=new TreeNode(14);
//		TreeNode t4=new TreeNode(4);
//		TreeNode t5=new TreeNode(8);
//		TreeNode t6=new TreeNode(12);
//		TreeNode t7=new TreeNode(16);
		t1.left=t2;
		t1.right=t3;
//		t2.left=t4;
//		t2.right=t5;
//		t3.left=t6;
//		t3.right=t7;
		
//		t1.printNode();
		//
		
		TreeNode ans=convert(t1);
		while(ans!=null) {
			System.out.println(ans.val);
			ans=ans.right;
		}
		
	}
	
	public static TreeNode convert(TreeNode root) {
		if (root==null) {
			return root;
		}
		TreeNode last=null;
		convert(root, last);
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	public static TreeNode convert(TreeNode root, TreeNode last) {
		if (root==null) {
			return null;
		}
		TreeNode cur=root;
		if (cur.left!=null) {
			last=convert(root.left, last);
		}
		cur.left=last;
		if (last!=null) {
			last.right=cur;
		}
		last=cur;
		if (cur.right!=null) {
			last=convert(root.right, last);
		}
		return last;
	}

}


/*
 * 牛客网		中序遍历
 */
class Solution {
    TreeNode tail = null;
    TreeNode head = null;
    public TreeNode Convert(TreeNode root) {
        ConvertSub(root);
        return head;
    }
     
    private void ConvertSub(TreeNode root) {
        if(root==null) return;
        ConvertSub(root.left);
        if (tail == null) {
            tail = root;
            head = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        ConvertSub(root.right);
    }
}

