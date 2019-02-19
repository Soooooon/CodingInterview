package code;
/**
 * 面试题33：二叉搜索树的后序遍历序列
 * @author Leon Song
 *
 */
public class NO33_SequenceOfBSTTest {
	public static void main(String[] args) {
		//
		int[] sequence= {5,7,6,9,11,10,8};
		//
		System.out.println(verifySequenceOfBST(sequence));
	}
	
	public static boolean verifySequenceOfBST(int[] sequence) {
		if (sequence.length==0) {
			return false;
		}
		return verifySequenceOfBST(sequence, 0, sequence.length-1);
	}
	public static boolean verifySequenceOfBST(int[] sequence,int start,int indexRoot) {
		if (start==indexRoot) {
			return true;
		}
		
		int index=start;
		while(sequence[index]<sequence[indexRoot]) {
			index++;
		}
		
		for (int i = index; i < indexRoot; i++) {
			if (sequence[i]<sequence[indexRoot]) {
				return false;
			}
		}
		
		if (index==start||index==indexRoot) {
			return verifySequenceOfBST(sequence, start, indexRoot-1);
		} else  {
			return verifySequenceOfBST(sequence, start, index-1)&&verifySequenceOfBST(sequence, index, indexRoot-1);
		}
	}
}
