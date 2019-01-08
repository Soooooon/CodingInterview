package code;
/**
 * 面试题4：二维数组中的查找
 * 问题：74
 * @author Leon Song
 *
 */
public class NO4_SearchMatrixTest {
	public static void main(String[] args) {
		//
		int[][] matrix= {{1,3,5,7},
						 {10,11,16,20},
						 {23,30,34,50}};
		int target=13;
		//
		System.out.println(searchMatrix(matrix, target));
		
	}
	/**
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix,int target) {
		/**
		 * 由于数组的层次关系，从右上角开始搜索，进行筛选。
		 */
		int rows=matrix.length;
		if (rows==0) {
			return false;
		}
		int cols=matrix[0].length;
		int indexRow=0;
		int indexCol=cols-1;
		while(indexRow<rows&&indexCol>=0) {
			if (matrix[indexRow][indexCol]<target) {
				indexRow++;
			} else if (matrix[indexRow][indexCol]>target) {
				indexCol--;
			} else {
				return true;
			}
		}
		return false;
	}
}
