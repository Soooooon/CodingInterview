package code;

import java.util.HashSet;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * @author Leon Song
 *
 */
public class NO39_MoreThanHalfNumberTest {
	public static void main(String[] args) {
		//
		int[] array= {1,2,3,2,2,2,5,4,2};
		//
//		System.out.println(partition(array, 0, array.length-1));
		System.out.println(moreThanHalfNumber(array));
	}
	public static int moreThanHalfNumber(int[] array) {
		if (array.length==0) {
			return 0;
		}
		if (array.length==1) {
			return array[0];
		}
		
		return moreThanHalfNumber(array, 0, array.length-1);
	}
	private static int moreThanHalfNumber(int[] array,int begin,int end) {
		int index=partition(array, begin, end);
		if (index==array.length/2) {
			int ans=array[index];
			int count=0;
			for(int x:array) {
				if (x==ans) {
					count++;
				}
			}
			if (count*2<=array.length) {
				return 0;
			} else {
				return ans;
			}
		} else if (index<array.length/2) {
			return moreThanHalfNumber(array, index+1, end);
		} else {
			return moreThanHalfNumber(array, begin, index-1);
		}
	}
	private static int partition(int[] array, int begin, int end) {
		int index=begin;
		int i=begin;
		int j=end+1;
		while(true) {
			while(array[index]>array[++i]) if(i>=end) break;
			while(array[index]<array[--j]) if(j<=begin) break;
			if (i>=j) break;
			exch(array, i, j);
		}
		exch(array, index, j);
		return j;
	}
	private static void exch(int[] array,int i,int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
