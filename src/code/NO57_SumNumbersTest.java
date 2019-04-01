package code;

import java.util.ArrayList;

public class NO57_SumNumbersTest {
	public static void main(String[] args) {
		//
		int[] array= {1,2,4,7,11,15};
		int sum=15;
		System.out.println(twoSum(array, sum).toString());
		//
//		int sum=100;
//		ArrayList<ArrayList<Integer>> ans=findContinuousSequence(sum);
//		for (int i = 0; i < ans.size(); i++) {
//			System.out.println(ans.get(i).toString());
//		}
	}
	public static ArrayList<Integer> twoSum(int[] array,int sum) {
		int length=array.length;
		
		int start=0;
		int end=length-1;
		
		ArrayList<Integer> ans=new ArrayList<>();
		int temp;
		while(start<end) {
			temp=array[start]+array[end];
			
			if (temp==sum) {
				ans.add(array[start]);
				ans.add(array[end]);
				break;
			} else if (sum>temp) {
				start++;
			} else {
				end--;
			}
			
		}
		return ans;
	}
	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int k=2;
		while((k-1)*k/2<sum) {
			int temp=sum-(k-1)*k/2;
			if (temp%k==0) {//整除
				int x=temp/k;
				ArrayList<Integer> cur=new ArrayList<>();
				for (int i = 0; i < k; i++) {
					cur.add(x++);
				}
				ans.add(0,cur);
			}
			k++;
		}
		return ans;
	}
}
