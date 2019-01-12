package code;
/**
 * 面试题10：斐波那契数列
 * @author Soon
 *
 */
public class NO10_FibonacciTest {
	public static void main(String[] args) {
		//
		int n=100;
		
		System.out.println(fibonacci(n));
		
		//
		
	}
	public static long fibonacci(int n) {
		if (n==0)
			return 0;
		if(n==1)
			return 1;
		long fibone=1;
		long fibtwo=0;
		long fibn=1;
		for(int i=0;i<=n;i++) {
			fibn=fibone+fibtwo;
			fibtwo=fibone;
			fibone=fibn;
		}
		return fibn;
	}
}
