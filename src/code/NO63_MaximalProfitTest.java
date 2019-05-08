package code;

import java.util.PriorityQueue;

public class NO63_MaximalProfitTest {
	public static void main(String[] args) {
		//
		int[] price = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(price));
		//
	}

	public static int maxProfit(int[] price) {
		int len = price.length;
		int max = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int index = 0;
		while (index < len) {
			pq.add(price[index]);
			max = Math.max(max, price[index] - pq.peek());
			index++;
		}
		return max;
	}
}
