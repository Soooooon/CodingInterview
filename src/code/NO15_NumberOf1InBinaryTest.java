package code;
/**
 * 面试题15：二进制中的1的个数
 * leetcode:191
 * @author Soon
 *
 */
public class NO15_NumberOf1InBinaryTest {
	public static void main(String[] args) {
		//
		int n=1023;
		//
		System.out.println(numberOf1InBinary_method1(n));
	}
	/**
	 * 方法一
	 * @param n
	 * @return
	 */
	public static int numberOf1InBinary_method1(int n) {
		int count=0;
		int flag=1;
		while(flag!=0) {
			if ((n&flag)!=0) {
				count++;
			}
			flag<<=1;
		}
		return count;
	}
	/**
	 * 方法二
	 * @param n
	 * @return
	 */
	public static int numberOf1InBinary_method2(int n) {
		int count = 0;
		while (n!=0){
			n = n & (n-1);
			count++;
		}
		return count;
	}
}
