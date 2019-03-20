package code;

import java.util.HashMap;

public class NO50_FirstNotRepeatingCharTest {
	public static void main(String[] args) {
		//
//		String str="abaccdeff";
//		System.out.println(firstNotRepeatingChar(str));
		//
		int[] nums= {2,2,3,2};
		System.out.println(singleNumber(nums));
		//
	}
	public static int firstNotRepeatingChar(String str) {
		HashMap<Character, Integer> hm=new HashMap<>();
		char temp;
		for (int i = 0; i < str.length(); i++) {
			temp=str.charAt(i);
			if (hm.containsKey(temp)) {
				hm.replace(temp, hm.get(temp)+1);
			} else {
				hm.put(temp, 1);
			}
		}
		
		for (int i = 0; i < str.length(); i++) {
			temp=str.charAt(i);
			if (hm.get(temp)==1) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static int singleNumber(int[] nums) {
		int ans=0;
		int mask;
		int count;
		for (int i = 0; i < 32; i++) {
			mask=1<<i;
			count=0;
			for (int j = 0; j < nums.length; j++) {
				if ((mask&nums[j])!=0) {
					count++;
				}
			}
			if (count%3==1) {
				ans=mask|ans;
			}	
		}
		return ans;
	}
}
