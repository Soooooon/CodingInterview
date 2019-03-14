package code;
/**
 * 面试题46:把数字翻译成字符串
 * @author Leon Song
 *
 */
public class NO46_TranslateNumbersToStringsTest {
	public static void main(String[] args) {
		//
		int num=12258;
		//
		System.out.println(translateCount(num));
	}
	public static int translateCount(int num) {
		String str=String.valueOf(num);			
		return solve(str);
	}
	public static int solve(String str) {
		if (str.length()<=1) {
			return 1;
		}
		int count=0;
		
		if (str.substring(0, 1).compareTo("26")>0) {
			count+=solve(str.substring(1));
		} else {
			count+=solve(str.substring(1));
			count+=solve(str.substring(2));
		}
		return count;
	}
}
