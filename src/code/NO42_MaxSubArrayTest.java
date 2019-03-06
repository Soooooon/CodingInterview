package code;
/**
 * 面试题42：连续子数组的最大和
 * leetcode：53
 * @author Leon Song
 *
 */
public class NO42_MaxSubArrayTest {
	public static void main(String[] args) {
		//
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		//
		System.out.println(maxSubArray(nums));
		
	}
	public static int maxSubArray(int[] nums) {
		int max=Integer.MIN_VALUE;
		int length=nums.length;
		int temp=0;
		for (int i = 0; i < length; i++) {
			if (temp<=0) {
				temp=nums[i];
			} else {
				temp+=nums[i];
			}
			if (temp>max) {
				max=temp;
			}
		}
		return max;
	}
}
