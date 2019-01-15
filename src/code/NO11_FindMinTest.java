package code;
/**
 * 面试题11：旋转数组的最小数字
 * leetcode：153
 * @author Leon Song
 *
 */
public class NO11_FindMinTest {
	public static void main(String[] args) {
		//
		int[] nums= {1};
		//
		System.out.println(findMin(nums));
		
	}
	public static int findMin(int[] nums) {
		int start=0;
		int end=nums.length-1;
		int mid=start;
		
		while(nums[start]>=nums[end]) {
			if (end-start<=1) {
				mid=end;
				break;
			}
			mid=(start+end)/2;
			if (nums[mid]>=nums[start]) {
				start=mid;
			} else {
				end=mid;
			}
		}
		return nums[mid];
	}
}
