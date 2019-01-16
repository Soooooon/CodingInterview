package code;
/**
 * 面试题13：机器人的运动范围
 * leetcode:无
 * @author Leon Song
 *
 */
public class NO13_RobotMoveTest {
	public static void main(String[] args) {
		//
		int threshold=2;
		int rows=4;
		int cols=5;
		
		//
//		System.out.println(satisfy(threshold, rows, cols));
		System.out.println(movingCount_method2(threshold, rows, cols));
		
	}
	/**
	 * 方法一
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int movingCount_method1(int threshold,int rows,int cols) {
		if (threshold<0||rows<0||cols<0) {
			return 0;
		}
		int count=0;
		
		boolean[][] visited=new boolean[rows][cols];
		count=solve(threshold, rows, cols, 0, 0, count, visited);
		
		return count;
	}
	
	public static int solve(int threshold,int rows,int cols,int row,int col,int count,boolean[][] visited) {
		if (satisfy(threshold, rows, cols, row, col, visited)) {
			
			visited[row][col]=true;
			count++;
			
			count=solve(threshold, rows, cols, row+1, col, count, visited);
			count=solve(threshold, rows, cols, row, col+1, count, visited);
			
			
		}
		return count;
	}
	/**
	 * 方法二
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int movingCount_method2(int threshold,int rows,int cols) {
		if (threshold<0||rows<0||cols<0) {
			return 0;
		}
		boolean[][] visited=new boolean[rows][cols];
		return solve_method2(threshold, rows, cols, 0, 0, visited);
	}
	
	public static int solve_method2(int threshold,int rows,int cols,int row,int col,boolean[][] visited){
		if (satisfy(threshold, rows, cols, row, col, visited)) {
			visited[row][col]=true;
			return 1+solve_method2(threshold, rows, cols, row+1, col, visited)
					+solve_method2(threshold, rows, cols, row, col+1, visited);
		} else {
			return 0;
		}
	}
	
	public static boolean satisfy(int threshold,int rows,int cols,int row,int col,boolean[][] visited) {
		if (row<0||row>=rows||col<0||col>=cols||visited[row][col]==true) {
			return false;
		}
		int sum=0;
		while(row>0) {
			sum+=row%10;
			row/=10;
		}
		while(col>0) {
			sum+=col%10;
			col/=10;
		}
		if (sum>threshold) {
			return false;
		} else {
			return true;
		}
	}
}
