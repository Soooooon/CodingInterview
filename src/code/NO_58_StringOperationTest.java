package code;

import java.util.Stack;

public class NO_58_StringOperationTest {
	public static void main(String[] args) {
		//
//		String str=" ";
//		System.out.println(reverstString(str));
		//
		String str="abcXYZdef";
		int n=3;
		System.out.println(leftRotateString(str, n));
	}
	public static String reverstString(String str) {
		String[] strs=str.split(" ");
		if (strs.length==1||strs.length==0) {
			return str;
		}
		StringBuilder sb=new StringBuilder();
		for (int i = strs.length-1; i >0; i--) {
			sb.append(strs[i]);
			sb.append(" ");
		}
		sb.append(strs[0]);
		
		return sb.toString();
	}
	public static String leftRotateString(String str,int n) {
		int length=str.length();
		if (length==0) {
			return str;
		}
		n%=length;
		
		String left=str.substring(0, n);
		String right=str.substring(n,length);
		
		StringBuilder sb=new StringBuilder();
		sb.append(right);
		sb.append(left);
		
		return sb.toString();
	}
}
