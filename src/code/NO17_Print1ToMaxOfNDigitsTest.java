package code;

/**
 * 面试题17：打印从1到最大的n位数
 * leetcode：无
 * @author Leon Song
 *
 */
public class NO17_Print1ToMaxOfNDigitsTest {
	public static void main(String[] args) {
		//
		int n=4;
		//
		print1ToMaxOfNDigits(n);
	}
	
	public static void print1ToMaxOfNDigits(int n) {
		int[] num=new int[n+1];
		
		num[0]=0;
		
		while(increase(num)) {
			printNum(num);
		}
	}
	
	public static boolean increase(int[] num) {
		num[0]+=1;
		
		//进位
		int index=0;
		while(num[index]%10==0) {
			num[index++]=0;
			num[index]+=1;
		}
		
		if (num[num.length-1]==1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void printNum(int[] num) {
		int end=num.length-1;
		while(num[end]==0) {
			end--;
		}
		String ans="";
		for (int i = 0; i <= end; i++) {
			ans=num[i]+ans;
		}
		
		System.out.println(ans);	
	}
}
