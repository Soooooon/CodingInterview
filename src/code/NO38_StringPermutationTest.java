package code;
/**
 * 面试题38：字符串的排列
 * leetcode：567
 * @author Leon Song
 *
 */

import java.util.ArrayList;
import java.util.HashSet;


public class NO38_StringPermutationTest {
	public static void main(String[] args) {
		//
//		String str="abc";
		String s1="ab";
		String s2="eidbaooo";
		//
		System.out.println(checkInclusion(s1, s2));
	}
	public static boolean checkInclusion(String s1,String s2) {
		if (s1.length()>s2.length()) {
			return false;
		}
		int[] countS1=count(s1);
		for (int i = 0; i <= s2.length()-s1.length(); i++) {
			int[] countS2=count(s2.substring(i, i+s1.length()));
			if (equal(countS1, countS2)) {
				return true;
			}
		}
		return false;
	}
	private static int[] count(String str) {
		int[] count=new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)-'a']++;
		}
		return count;
	}
	private static boolean equal(int[] count1,int[] count2) {
		for (int i = 0; i < 26; i++) {
			if (count1[i]!=count2[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static ArrayList<String> permutation(String str){
		char[] chs=str.toCharArray();
		boolean[] visit=new boolean[chs.length];
		ArrayList<String> ans=new ArrayList<>();
		String cur="";
		HashSet<String> exist=new HashSet<>();
		permuatation(cur, visit, chs, exist);
		for(String s:exist) {
			ans.add(s);
		}
		return ans;
	}
	private static void permuatation(String cur,boolean[] visit,char[] chs,HashSet<String> exist) {
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				visit[i]=true;
				String temp=cur+chs[i];
				if (temp.length()==chs.length&&!exist.contains(temp)) {
					exist.add(temp);
				} else {
					permuatation(temp, visit, chs, exist);
				}
				visit[i]=false;
			}
		}
	}
	
}
