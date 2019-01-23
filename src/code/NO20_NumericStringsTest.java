package code;

/**
 * 面试题20：表示数值的字符串
 * leetcode：无
 * @author Leon Song
 *
 */
public class NO20_NumericStringsTest {
	public static void main(String[] args) {
		//
		String num="12e+5";
		char[] str=num.toCharArray();
		//
		System.out.println(isNumeric_method1(str));
		
	}
	/**
	 * 方法一：采用正则表达式
	 * @param str
	 * @return
	 */
	public static boolean isNumeric_method1(char[] str) {
		//	[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?
		String reg="[\\+\\-]?(([0-9]+(\\.[0-9]*)?)|(\\.[0-9]+))([eE][\\+\\-]?[0-9]+)?";
		String num=String.valueOf(str);
		
		boolean ans=num.matches(reg);
		return ans;
	}
	/**
	 * 方法二
	 * @param str
	 * @return
	 */
	public static boolean isNumeric_method2(char[] str) {
		if (str.length==0) {
			return false;
		}
		int index=0;
		boolean flag=scanInteger(str, index);
		
		if (index<str.length&&str[index]=='.') {
			index++;
			flag=scanInteger(str, index)||flag;
		}
		
		if (index<str.length&&(str[index]=='E'||str[index]=='e')) {
			index++;
			flag=flag&&scanInteger(str, index);
		}
		return flag&&index==str.length;
	}
	/*
	 * 检测带符号整数部分
	 */
	public static boolean scanInteger(char[] str,int index) {
		if (index<str.length&&(str[index]=='+'||str[index]=='-')) {
			index++;
		}
		return scanUnsignedInteger(str, index);
	}
	/*
	 * 检测是否存在整数部分
	 */
	public static boolean scanUnsignedInteger(char[] str,int index) {
		int start=index;
		while(index<str.length&&str[index]>='0'&&str[index]<='9') {
			index++;
		}
		return start<index;
	}
	
}
