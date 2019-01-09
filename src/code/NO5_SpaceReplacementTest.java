package code;

import java.util.Arrays;

/**
 * 面试题5：替换空格
 * leetcode无该题，采用nowcoder测试
 * @author Leon Song
 *
 */
public class NO5_SpaceReplacementTest {
	public static void main(String[] args) {
		//
//		StringBuffer str=new StringBuffer("We Are Happy.");
//		char[] str= {' ','W','e',' ',' ','A','r','e',' ','H','a','p','p','y'};
		char[] str= {'a','b','c'};
		//
//		System.out.println(replaceSpace_method1(str));
		System.out.println(replaceSpace_method2(str));
	}
	/**
	 * 在java中采用string数据类型被不能达到该题的效果
	 * @param str
	 * @return
	 */
	public static String replaceSpace_method1(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				str.replace(i, i+1, "%20");
				i+=2;
			}
		}
		return str.toString();
	}
	/**
	 * 先计算扩容后数组长度，然后从后向前移动原数组
	 * @param str
	 * @return
	 */
	public static String replaceSpace_method2(char[] str) {
		int length=str.length;
		int copyIndex=length-1;
		for (int i = 0; i < str.length; i++) {
			if (str[i]==' ') {
				length+=2;
			}
		}
		str=Arrays.copyOf(str, length);
		int index=length-1;
		while(copyIndex>=0) {
			if (str[copyIndex]==' ') {
				copyIndex--;
				str[index--]='0';
				str[index--]='2';
				str[index--]='%';
			} else {
				str[index--]=str[copyIndex--];
			}
		}
		return String.valueOf(str);
	}
}
