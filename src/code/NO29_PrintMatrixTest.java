package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题29：顺时针打印矩阵
 * leetcode：54
 * @author Leon Song
 *
 */

public class NO29_PrintMatrixTest {
	public static void main(String[] args) {
		//
		int[][] matrix= {{1,2,3},
						 {4,5,6},
						 {7,8,9}};
		//
		System.out.println(spiralOrder(matrix).toString());
	}
	public static List<Integer> spiralOrder(int[][] matrix){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		
		int rows=matrix.length;
		if (rows==0) {
			return ans;
		}
		int cols=matrix[0].length;
		int rounds=rows<cols?(rows-1)/2:(cols-1)/2;
		
		for (int i = 0; i <= rounds; i++) {
			printCircle(matrix, i, ans);			
		}
		
		return ans;
	}
	public static void printCircle(int[][] matrix,int round,List<Integer> ans) {
		int row=matrix.length-1;
		int col=matrix[0].length-1;
		
		if (round*2==row) {
			for (int i = round; i <= col-round; i++) {
				ans.add(matrix[round][i]);
			}
		} else if (round*2==col) {
			for (int i = round; i <= row-round; i++) {
				ans.add(matrix[i][round]);
			}
		} else {
			for (int i = round; i <= col-round; i++) {
				ans.add(matrix[round][i]);
			}
			for (int i = round+1; i <= row-round-1; i++) {
				ans.add(matrix[i][col-round]);
			}
			for (int i = col-round; i >= round+1; i--) {
				ans.add(matrix[row-round][i]);
			}
			for (int i = row-round; i >= round+1; i--) {
				ans.add(matrix[i][round]);
			}
		}
	}
}
