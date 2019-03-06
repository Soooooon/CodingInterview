package code;
/**
 * 面试题43:1~n整数中1出现的次数
 * leetcode：233
 * @author Leon Song
 *
 */
public class NO43_CountDigitOneTest {
	public static void main(String[] args) {
		//
		int n=13;
		//
		System.out.println(countDigitOne_method1(n));
	}
	public static int countDigitOne_method1(int n) {
		int ans=0;
		int a=1;
		int b=1;
		while(n>0) {
			ans += (n + 8) / 10 * a + (n % 10 == 1?b:0);
            b += n % 10 * a;
            a *= 10;
            n /= 10;
		}
		return ans;
	}
	
	public static int countDigitOne_method2(int n) {
		int result = 0;
        if(n <= 0){
            return result;
        }
        String number = Integer.toString(n);
        for(int i = 0; i < number.length(); i++){
            if(i == 0){
                if(number.charAt(i) == '1'){
                    int right = 0;
                    for(int j = 1; j < number.length(); j++){
                        right = right * 10 + number.charAt(j) - '0';
                    }
                    result += right + 1;
                }else{
                    result += Math.pow(10, number.length() - 1);
                }
            }else if(i == number.length() - 1){
                int left = 0;
                for(int j = 0; j < number.length() - 1; j++){
                    left = left * 10 + number.charAt(j) - '0';
                }
                result += left + 1;
                if(number.charAt(i) == '0'){
                    result--;
                }
            }else{
                int left = 0, right = 0;
                for(int j = 0; j < i; j++){
                    left = left * 10 + number.charAt(j) - '0';
                }
                for(int j = i + 1; j < number.length(); j++){
                    right = right * 10 + number.charAt(j) - '0';
                }
                if(number.charAt(i) == '0'){
                    result += left * Math.pow(10, number.length() - i - 1);
                }else if(number.charAt(i) == '1'){
                    result += left * Math.pow(10, number.length() - i - 1) + right + 1;
                }else{
                    result += (left + 1) * Math.pow(10, number.length() - i - 1);
                }
            }
        }
        return result;
	}
}
