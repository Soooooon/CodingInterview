package code;
/**
 * 面试题16：数值的整数次方
 * leetcode：50
 * @author Leon Song
 *
 */
public class NO16_PowerTest {
	public static void main(String[] args) {
		//
		double x=1.0;
		int n=-2147483648;
		//
		System.out.println(power(x, n));
		
	}
	/**
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public static double power(double x,int n) {
		if (n==0) {
			return 1.0;
		}
		boolean sign=n>0?true:false;
		long exp=n;
		exp=sign?exp:-exp;
		double ans=powerUnsigned(x, exp);
		
		if (sign) {
			return ans;
		} else {
			return 1/ans;
		}
	}
	public static double powerUnsigned(double x,long n) {
		if (n==0) {
			return 1.0;
		}
		if (n==1) {
			return x;
		}
		double temp;
		if (n%2==0) {//偶数
			temp=powerUnsigned(x, n>>1);
			return temp*temp;
		} else {//奇数
			temp=powerUnsigned(x, (n-1)>>1);
			return temp*temp*x;
		}
	}
}
