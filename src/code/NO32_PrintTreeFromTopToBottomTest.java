package code;
/**
 * 面试题32：从上到下打印二叉树
 * leetcode：102
 * @author Leon Song
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class NO32_PrintTreeFromTopToBottomTest {
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
		for(List<Integer> x:levelOrder_method2(t1)) {
			System.out.println(x.toString());
		}
	}
	
	public static List<List<Integer>> levelOrder_method1(TreeNode root){
		List<List<Integer>> ans=new ArrayList<>();
		if (root==null) {
			return ans;
		}
		Queue<ArrayList<TreeNode>> queue=new LinkedList<>();
		queue.add(new ArrayList<TreeNode>() {{
			add(root);
		}});
		while(!queue.isEmpty()) {
			ArrayList<Integer> value=new ArrayList<>();
			ArrayList<TreeNode> son=new ArrayList<>();
			for(TreeNode t:queue.peek()) {
				value.add(t.val);
				if (t.left!=null) {
					son.add(t.left);
				}
				if (t.right!=null) {
					son.add(t.right);
				}
			}
			ans.add(value);
			if (!son.isEmpty()) {
				queue.add(son);
			}
			queue.poll();
		}
		return ans;
	}
	
	public static List<List<Integer>> levelOrder_method2(TreeNode root){
		List<List<Integer>> lists= new ArrayList<>();
		if(root==null)
            return lists;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list= new ArrayList<>();
            while (size!=0){
                TreeNode treeNode= queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null)
                    queue.offer(treeNode.left);
                if(treeNode.right!=null)
                    queue.offer(treeNode.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
	}
}
