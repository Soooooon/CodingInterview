package code;
/**
 * 面试题47：礼物的最大价值
 * @author Leon Song
 *
 */
public class NO47_MaxValuesOfGiftsTest {
	public static void main(String[] args) {
		//
		int[][] map= {{1,10,3,8},
					  {12,2,9,6},
					  {5,7,4,11},
					  {3,7,16,5}};
		//
		System.out.println(maxValues_method2(map));
	}
	
	/*
	 * 递归版
	 */
	public static int maxValues_method1(int[][] map) {
		return df(map, 0, 0);
	}
	private static int df(int[][] map,int x,int y) {
		int rows=map.length;
		int cols=map[0].length;
		
		if (x==rows-1&&y==cols-1) {
			return map[x][y];
		}
		
		if (x==rows-1) {
			return map[x][y]+df(map, x, y+1);
		} else if (y==cols-1) {
			return map[x][y]+df(map, x+1, y);
		} else {
			return Math.max(map[x][y]+df(map, x, y+1), map[x][y]+df(map, x+1, y));
		}
	}
	
	/*
	 * 迭代版
	 */
	public static int maxValues_method2(int[][] map) {
		int rows=map.length;
		int cols=map[0].length;
		int[][] maxValues=new int[rows][cols];
		for (int i = rows-1; i >= 0; i--) {
			for (int j = cols-1; j >= 0; j--) {
				if (i==rows-1&&j==cols-1) {
					maxValues[rows-1][cols-1]=map[rows-1][cols-1];
				} else if (j==cols-1) {
					maxValues[i][j]=maxValues[i+1][j]+map[i][j];
				} else if (i==rows-1) {
					maxValues[i][j]=maxValues[i][j+1]+map[i][j];
				} else {
					maxValues[i][j]=Math.max(maxValues[i+1][j]+map[i][j], maxValues[i][j+1]+map[i][j]);
				}
			}
		}
		return maxValues[0][0];
	}
}
