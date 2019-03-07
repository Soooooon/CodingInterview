package code;
/**
 * 面试题44：数字序列中的某一位的数字
 * leetcode：400
 * @author Leon Song
 *
 */
public class NO44_FindNthDigitTest {
	public static void main(String[] args) {
		//
		System.out.println(findNthDigit(1001));
		System.out.println(verify(1001));
		//
		
	}
	public static int findNthDigit(int n) {
		int digit=1;
		int x;
		int re;
		while(true) {
			int allCounts=countDigit(digit);
			if (allCounts<n) {
				n-=allCounts;
				digit++;
			} else {
				x=(n-1)/digit;
				re=(n-1)%digit;
				break;
			}
		}
		int num=(int) Math.pow(10, digit-1)+x;
		return String.valueOf(num).charAt(re)-'0';
	}
	private static int countDigit(int digit) {
		return (int) (digit*9*Math.pow(10, digit-1));
	}
	
	public static int verify(int n) {
		if (n<1) {
			return 0;
		}
		StringBuffer sb=new StringBuffer();
		int index=1;
		while(sb.length()<n) {
			sb.append(index++);
		}
		return sb.charAt(n-1)-'0';
	}
}
