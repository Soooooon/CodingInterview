package code;
/**
 * 面试题10：斐波那契数列
 * @author Leon Song
 *
 */
public class NO10_FibonacciTest {
	public static void main(String[] args) {
		//
		int n=100;
		//
		System.out.println(fibonacci(n));
		
	}
	public static long fibonacci(int n) {
		if (n==0)
			return 0;
		if(n==1)
			return 1;
		long fibOne=1;
		long fibTwo=0;
		long fibN=1;
		for(int i=0;i<=n;i++) {
			fibN=fibOne+fibTwo;
			fibTwo=fibOne;
			fibOne=fibN;
		}
		return fibN;
	}
}
