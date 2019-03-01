package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * 面试题37：序列化二叉树
 * leetcode：297
 * @author Leon Song
 *
 */
public class NO37_SerializeBinaryTreeTest {
	public static void main(String[] args) {
		//
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.left=t5;
		t3.right=t6;
		
		String data="1,2,4,null,null,null,3,5,null,null,6,null,null";
		
//		t1.printNode();
		
		//
//		System.out.println(serialize(t1));
		deserialize(data).printNode();
		
//		System.out.println(serialize(deserialize(data)));
//		deserialize(serialize(t1)).printNode();
	}
	/*
	 * 前序遍历
	 */
	public static String serialize(TreeNode root) {
		StringBuffer stream=new StringBuffer("");
		serialize(root, stream);
		stream.deleteCharAt(stream.length()-1);
		return stream.toString();
	}
	private static void serialize(TreeNode root,StringBuffer stream) {
		if (root==null) {
			stream.append("null,");
			return;
		}
		stream.append(root.val+",");
		serialize(root.left, stream);
		serialize(root.right, stream);
	}
	
	
	public static TreeNode deserialize(String data) {
		String[] strs=data.split(",");
		Queue<String> queue=new LinkedList<>(Arrays.asList(strs));
		return deserialize(queue);
		
	}
	private static TreeNode deserialize(Queue<String> que) {
		String str=que.poll();
		if (str.equals("null")) {
			return null;
		}
		TreeNode root=new TreeNode(Integer.parseInt(str));
		root.left=deserialize(que);
		root.right=deserialize(que);
		return root;
	}
	
}
