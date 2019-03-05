package code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题41：数据流的中位数
 * leetcode：295
 * @author Leon Song
 *
 */
public class NO41_StreamMedianTest {
	public static void main(String[] args) {
		//
		MedianFinder mf=new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		//
		
		
	}
	
}
class MedianFinder{
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	int size;
	public MedianFinder() {
		this.size=0;
		this.minHeap=new PriorityQueue<>();
		this.maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
	}
	public void addNum(int num) {
		size=minHeap.size()+maxHeap.size();
		if (minHeap.isEmpty()) {
			minHeap.add(num);
			size++;
			return;
		}
		
		if (size%2!=0) {//奇数
			if (num>minHeap.peek()) {
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if (num<maxHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
		size++;
	}
	public double findMedian() {
		if (minHeap.isEmpty()) {
			return -1.0;
		}
		if (size%2!=0) {//奇数
			return minHeap.peek()*1.0;
		} else {
			return (minHeap.peek()+maxHeap.peek())*0.5;
		}
	}
}
