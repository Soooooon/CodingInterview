package code;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 面试题34,：二叉树和中为某一直的路径
 * leetcode：112，113
 * @author Leon Song
 *
 */
public class NO34_PathInTreeTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(5);
		TreeNode t2=new TreeNode(4);
		TreeNode t3=new TreeNode(8);
		TreeNode t4=new TreeNode(11);
		TreeNode t5=new TreeNode(13);
		TreeNode t6=new TreeNode(4);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(2);
		TreeNode t9=new TreeNode(1);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.left=t5;
		t3.right=t6;
		t4.left=t7;
		t4.right=t8;
		t6.right=t9;
		
//		t1.printNode();
		
		//
		List<List<Integer>> ans=pathSum(t1, 22);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).toString());
		}
	}
	
	public static boolean hasPathSum(TreeNode root,int sum) {
		if (root==null) {
			return false;
		}
		
		if (root.left==null&&root.right==null) {
			if (root.val==sum) {
				return true;
			} else {
				return false;
			}
		}
		
		if (root.left!=null&&root.right!=null) {
			return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
		} else if (root.left!=null) {
			return hasPathSum(root.left, sum-root.val);
		} else {
			return hasPathSum(root.right, sum-root.val);
		}	
	}
	
	public static List<List<Integer>> pathSum(TreeNode root,int sum){
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> curSum=new ArrayList<>();
		
		hasPathSum(root, sum, ans, curSum);
		
		return ans;
	}
	public static void hasPathSum(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> curSum) {
		if (root==null) {
			return;
		}
		
		curSum.add(root.val);
		
		if (root.left==null&&root.right==null) {
			if (equalSum(curSum, sum)) {
				ans.add(new ArrayList<>(curSum));
			} else {
				return;
			}
		}
		
		if (root.left!=null) {
			hasPathSum(root.left, sum, ans, curSum);
			curSum.remove(curSum.size()-1);
		}
		if (root.right!=null) {
			hasPathSum(root.right, sum, ans, curSum);
			curSum.remove(curSum.size()-1);
		}
		
	}
	public static boolean equalSum(List<Integer> sumList,int sum) {
		int temp=0;
		for(int x:sumList) {
			temp+=x;
		}
		if (temp==sum) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
}
