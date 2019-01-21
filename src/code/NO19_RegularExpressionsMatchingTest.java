package code;
/**
 * 面试题19：正则表达式匹配
 * leetcode：10
 * @author Leon Song
 *
 */
public class NO19_RegularExpressionsMatchingTest {
	public static void main(String[] args) {
		//
		String s="mississippi";
		String p="mis*is*p*.";
		//
		System.out.println(isMatch(s, p));
		
	}
	public static boolean isMatch(String s,String p) {
		if (s.length()==0&&p.length()==0) {
			return true;
		} else if (p.length()==0) {
			return false;
		}
		return match(s, p, 0, 0);	
	}
	
	public static boolean match(String s,String p,int sIndex,int pIndex) {
		if (sIndex==s.length()&&pIndex==p.length()) {
			return true;
		}
		if (sIndex!=s.length()&&pIndex==p.length()) {
			return false;
		}
		
		if (pIndex<p.length()-1&&p.charAt(pIndex+1)=='*') {//当下一位是*
			if (sIndex<s.length()&&(p.charAt(pIndex)=='.'||s.charAt(sIndex)==p.charAt(pIndex))) {
				return match(s, p, sIndex, pIndex+2)
						||match(s, p, sIndex+1, pIndex)
						||match(s, p, sIndex+1, pIndex+2);
			} else {
				return match(s, p, sIndex, pIndex+2);
			}
		}
		if (sIndex<s.length()&&(p.charAt(pIndex)=='.'||s.charAt(sIndex)==p.charAt(pIndex))) {
			return match(s, p, sIndex+1, pIndex+1);
		}
		
		return false;
	}
}
