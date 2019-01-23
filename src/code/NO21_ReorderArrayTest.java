package code;

import java.util.Arrays;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * @author Leon Song
 *
 */
public class NO21_ReorderArrayTest {
	public static void main(String[] args) {
		//			  1 0 1 0 1 0 1
		int[] array= {1,2,3,4,5,6,7};
		//
		reOrderArray_method2(array);
		System.out.println(Arrays.toString(array));
	}
	/**
	 * 方法一：不保持相对顺序
	 * @param array
	 */
	public static void reOrderArray_method1(int[] array) {
		int start=0;
		int end=array.length-1;
		int temp;
		while(start<end) {
			while(start<end&&(array[start]&1)==1) {//是奇数
				start++;
			}
			while(end>start&&(array[end]&1)==0) {//是偶数
				end--;
			}
			if (start<end) {
				exch(array, start, end);
			}
			
//			start++;
//			end--;
		}	
	}
	/**
	 * 方法二：保持相对顺序，插入排序
	 * @param array
	 */
	public static void reOrderArray_method2(int[] array) {
		
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j >0&&((array[j]&1)>(array[j-1]&1)); j--) {
				exch(array, j, j-1);
			}
		}
	}
	
	public static void exch(int[] array,int x,int y) {
		int temp=array[x];
		array[x]=array[y];
		array[y]=temp;
	}
}
