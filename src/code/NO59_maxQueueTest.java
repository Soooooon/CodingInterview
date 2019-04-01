package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NO59_maxQueueTest {
	public static void main(String[] args) {
		//
		int[] num= {10,14,12,11};
		int size=0;
		System.out.println(maxInWindows(num, size).toString());
		//
		
		
	}
	public static ArrayList<Integer> maxInWindows(int[] num,int size){
		ArrayList<Integer> ans=new ArrayList<>();
		if (size==0) {
			return ans;
		}
		for (int start = 0; start <= num.length-size; start++) {
			PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			for (int i = start; i < start+size; i++) {
				pq.add(num[i]);
			}
			ans.add(pq.poll());
			
		}
		
		return ans;
	}
}
