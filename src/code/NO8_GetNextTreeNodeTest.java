package code;

import utils.TreeLinkNode;

/**
 * 面试题8：二叉树的下一个节点
 * @author Leon Song
 *
 */
public class NO8_GetNextTreeNodeTest {
	public static void main(String[] args) {
		//
		TreeLinkNode case1=TreeLinkNode.aCase();
//		case1.printNode();
		//
		System.out.println(getNextTreeNode(case1.right.right));
	}
	
	public static TreeLinkNode getNextTreeNode(TreeLinkNode pNode) {
		if (pNode.right!=null) {
			return getMin(pNode.right);
		} else if (pNode.next!=null&&pNode.next.left==pNode) {
			return pNode.next;
		} else {
			while(pNode.next!=null&&pNode.next.left!=pNode) {
				pNode=pNode.next;
			}
			return pNode.next;
		}
	}
	public static TreeLinkNode getMin(TreeLinkNode node) {
		if (node.left==null) {
			return node;
		} else {
			return getMin(node.left);
		}
	}
}
