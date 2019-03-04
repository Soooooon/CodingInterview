package code;
/**
 * 面试题40：最小的K个数
 * @author Leon Song
 *
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NO40_KLeastNumbersTest {
	public static void main(String[] args) {
		//
		int[] input= {4,5,1,6,2,7,3,8};
		int k=6;
		//
		System.out.println(getLeastNumbers_method2(input, k).toString());
	}
	
	public static ArrayList<Integer> getLeastNumbers_method1(int[] input,int k){
		ArrayList<Integer> ans=new ArrayList<>();
		if (k>input.length||k<=0) {
			return ans;
		}
		for (int i = 0; i < input.length; i++) {
			if (i<k) {
				insert(ans, input[i]);
			} else if (ans.get(k-1)>input[i]) {
				ans.remove(ans.size()-1);
				insert(ans, input[i]);
			}
		}
		return ans;
	}
	private static void insert(ArrayList<Integer> ans,int x) {
		if (ans.isEmpty()) {
			ans.add(x);
			return;
		}
		int index=0;
		while(index<ans.size()&&ans.get(index)<x) index++;
		ans.add(index, x);
	}
	
	/*
	 * 基于堆实现
	 */
	public static ArrayList<Integer> getLeastNumbers_method2(int[] input,int k){
		ArrayList<Integer> ans=new ArrayList<>();
		int length=input.length;
		if (k>input.length||k<=0) {
			return ans;
		}
		PriorityQueue<Integer> heap=new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}	
		});
		
		for (int i = 0; i < length; i++) {
			if (heap.size()<k) {
				heap.add(input[i]);
			} else if (heap.peek()>input[i]) {
				heap.poll();
				heap.add(input[i]);
			}
		}
		for(Integer x:heap) {
			ans.add(x);
		}
		
		return ans;
	}
}
