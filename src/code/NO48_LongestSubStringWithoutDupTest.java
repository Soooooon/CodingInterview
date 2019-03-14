package code;

import java.util.HashSet;

public class NO48_LongestSubStringWithoutDupTest {
	public static void main(String[] args) {
		//
		String str= "pwwkew";
		//
		System.out.println(longestSub(str));
	}
	public static int longestSub(String s) {
		int max=0;
		int temp;
		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> hs=new HashSet<>();
			hs.add(s.charAt(i));
			temp=1;
			for (int j = i+1; j < s.length(); j++) {
				if (hs.contains(s.charAt(j))) {
					break;
				}
				temp++;
				hs.add(s.charAt(j));
				
			}
			if (temp>max) {
				max=temp;
			}
			
			
		}
		return max;
	}
}
