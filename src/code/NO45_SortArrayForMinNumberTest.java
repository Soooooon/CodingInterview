package code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 面试题45：把数组排成最小的数
 * @author Leon Song
 *
 */
public class NO45_SortArrayForMinNumberTest {
	public static void main(String[] args) {
		//
		int[] numbers= {3,32,321};
		//
		System.out.println(printMinNumber(numbers));
	}
	public static String printMinNumber(int[] numbers) {
		int length=numbers.length;
		String[] strs=new String[length];
		
		for (int i = 0; i < length; i++) {
			strs[i]=numbers[i]+"";
		}
		
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String str1=o1+o2;
				String str2=o2+o1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuffer ans=new StringBuffer();
		
		for (String str:strs) {
			ans.append(str);
		}
		
		return ans.toString();
	}
	
	
	
	
}
