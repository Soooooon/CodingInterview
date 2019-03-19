package code;

public class NO49_UglyNumberTest {
	public static void main(String[] args) {
		//
		int num=10;
		//
//		System.out.println(isUglyNum(num));
		System.out.println(nthUglyNumber(num));
	}
	public static boolean isUglyNum(int num) {
		if (num<=0) {
			return false;
		}
		int[] ugly= {2,3,5};
		int i=0;
		while(num>1) {
			if (num%ugly[i]==0) {//能被整除
				num/=ugly[i];
			} else {
				i++;
			}
			if (i==ugly.length) {
				return false;
			}
		}
		return true;
	}
	
	public static int nthUglyNumber(int n) {
		int[] nums=new int[n];
		
		nums[0]=1;
		
		int[] ugly= {2,3,5};
		
		int index_2=0;
		int index_3=0;
		int index_5=0;
		
		int indexN=1;
		while(indexN<n) {
			while(nums[index_2]*2<=nums[indexN-1]) index_2++;
			while(nums[index_3]*3<=nums[indexN-1]) index_3++;
			while(nums[index_5]*5<=nums[indexN-1]) index_5++;
			
			if (nums[index_2]*2<=nums[index_3]*3&&nums[index_2]*2<=nums[index_5]*5) {
				nums[indexN]=nums[index_2]*2;
				index_2++;
			} else if (nums[index_3]*3<=nums[index_2]*2&&nums[index_3]*3<=nums[index_5]*5) {
				nums[indexN]=nums[index_3]*3;
				index_3++;
			} else {
				nums[indexN]=nums[index_5]*5;
				index_5++;
			}
			indexN++;
		}
		return nums[n-1];
	}
}
