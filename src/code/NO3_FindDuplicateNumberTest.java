package code;
/**
 * 
 * 面试题3：数组中重复数的数字
 * 	问题一：287
 * 	问题二：442
 * 
 * @author Leon Song
 *
 */

import java.util.ArrayList;
import java.util.List;

public class NO3_FindDuplicateNumberTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,3,4,2,2};
		//
//		System.out.println(findDuplicates_method2(nums));
		System.out.println(findDuplicate(nums));
	}
	/**
	 * 问题一
	 * @param nums
	 * @return duplicates
	 */
	public static List<Integer> findDuplicates_method1(int[] nums){
		/**
		 * 需要额外o(n)空间
		 * 创建一个数组用来储存每个数字出现的次数，当次数大于1时，则重复出现。
		 */
		List<Integer> duplicates=new ArrayList<>();
		int length=nums.length;
		int[] counts=new int[length];
		int index;
		for (int i = 0; i < length; i++) {
			index=nums[i]-1;
			counts[index]++;
			if (counts[index]>1) {
				duplicates.add(nums[i]);
				counts[index]=-length;
			}
		}
		return duplicates;
	}
	public static List<Integer> findDuplicates_method2(int[] nums){
		/**
		 * 不需要额外o(n)空间
		 * 对数组中每个元素，将该索引对应元素取倒数，表明已经出现过该元素，则当检索到
		 * 元素为负时则表明，该元素已经出现过。
		 */
		List<Integer> duplicates=new ArrayList<>();
		int length=nums.length;
		int temp;
		for (int i = 0; i < length; i++) {
			temp=Math.abs(nums[i]);
			if (nums[temp-1]<0) {
				duplicates.add(temp);
			} else {
				nums[temp-1]=-nums[temp-1];
			}
		}
		
		return duplicates;
	}
	/**
	 * 问题二
	 * @param nums
	 * @return
	 */
	public static int findDuplicate(int[] nums) {
		int length=nums.length;
		int start=1;
		int end=length-1;
		int middle;
		int count;
		while(start<=end) {
			middle=(end-start)/2+start;
			count=countRange(nums, start, middle);
			if (start==end&&count>1) {
				return start;
			} else if (count>middle-start+1) {
				end=middle;
			} else {
				start=middle+1;
			}
		}
		return -1;
	}
	public static int countRange(int[] nums,int start,int end) {
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>=start&&nums[i]<=end) {
				count++;
			}
		}
		return count;
	}
}
