package code;
/**
 * 面试题12：矩阵中的路径
 * leetcode:无
 * @author Leon Song
 *
 */
public class NO12_StringPathInMatrixTest {
	public static void main(String[] args) {
		//
		char[] matrix= {'a','b','t','g','c','f','c','s','j','d','e','h'};
		int rows=3;
		int cols=4;
		char[] str= {'b','f','c','e'};
		//
		System.out.println(hasPath(matrix, rows, cols, str));
	}
	
	public static boolean hasPath(char[] matrix,int rows,int cols,char[] str) {
		char[][] mat=new char[rows][cols];
		int index=0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j]=matrix[index++];
			}
		}
		
		int len=0;
		boolean[][] visit=new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (solve(mat, visit, i, j, len, str)) {
					return true;
				}
				
			}
		}
		
		return false;
	}
	
	public static boolean solve(char[][] matrix,boolean[][] visit,int row,int col,int len,char[] str) {
		if (str.length==len) {
			return true;
		}
		
		boolean hasPath=false;
		
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		if (row>=0&&row<rows&&col>=0&&col<cols
				&&matrix[row][col]==str[len]
				&&visit[row][col]==false) {
			len++;
			visit[row][col]=true;
			
			hasPath=solve(matrix, visit, row-1, col, len, str)
					||solve(matrix, visit, row+1, col, len, str)
					||solve(matrix, visit, row, col-1, len, str)
					||solve(matrix, visit, row, col+1, len, str);
			
			if (!hasPath) {//若没有则退回
				len--;
				visit[row][col]=false;
			}
		}
		return hasPath;
	}
}
