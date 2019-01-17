package code;
/**
 * 面试题14：剪绳子
 * leetcode：无
 * @author Leon Song
 *
 */
public class NO14_CuttingRopeTest {
	public static void main(String[] args) {
		//
		int length=18;
		//
		System.out.println(maxProductAfterCutting_method1(length));
		
	}
	/**
	 * 方法一：动态规划
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting_method1(int length) {
		if (length<=1) {
			return 0;
		}
		if (length==2) {
			return 1;
		}
		if (length==3) {
			return 2;
		}
		int[] maxProduct=new int[length+1];
		maxProduct[0]=0;
		maxProduct[1]=1;
		maxProduct[2]=2;
		maxProduct[3]=3;
		for (int i = 4; i <= length; i++) {
			maxProduct[i]=findMax(maxProduct, i);
		}
		return maxProduct[length];
	}
	public static int findMax(int[] maxProduct,int length) {
		int max=length;
		int temp;
		for (int i = 1; i <= length/2; i++) {
			temp=maxProduct[i]*maxProduct[length-i];
			if (temp>max) {
				max=temp;
			}
		}
		return max;
	}
	/**
	 * 方法二：贪婪算法
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting_method2(int length) {
		if (length<=1) {
			return 0;
		}
		if (length==2) {
			return 1;
		}
		if (length==3) {
			return 2;
		}
		int max=1;
		
		while(length>=5) {
			max*=3;
			length-=3;
		}
		max*=length;
		return max;
	}
	
}
