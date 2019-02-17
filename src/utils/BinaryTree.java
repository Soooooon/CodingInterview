package utils;

public class BinaryTree {
	public TreeNode root;
	
	public BinaryTree(TreeNode root) {
		this.root=root;
	}
	
	public void printAll() {
		root.printNode();
	}
	
	public static BinaryTree aCase() {
		TreeNode node8=new TreeNode(8);
		TreeNode node9=new TreeNode(9);
		TreeNode node5=new TreeNode(5);
		node5.left=node8;
		node5.right=node9;
		
		TreeNode node4=new TreeNode(4);
		TreeNode node2=new TreeNode(2);
		node2.left=node4;
		node2.right=node5;
		
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		TreeNode node3=new TreeNode(3);
		node3.left=node6;
		node3.right=node7;
		
		TreeNode node1=new TreeNode(1);
		node1.left=node2;
		node1.right=node3;
		
		return new BinaryTree(node1);
	}
}
