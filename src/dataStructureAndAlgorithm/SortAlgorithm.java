package dataStructureAndAlgorithm;

import java.util.Arrays;

public class SortAlgorithm {
	public static void main(String[] args) {
		//
		int[] a= {3,7,5,2,8,9,1,6,4};
		//
		System.out.println("排序前："+Arrays.toString(a));
		
//		sortSelection(a);
//		sortInsertion(a);
//		sortHeap(a);
		sortQuick(a);
		
		System.out.println("排序后："+Arrays.toString(a));
	}
	
	/*
	 * 快速排序
	 */
	public static void sortQuick(int[] a) {
		sortQuick(a, 0, a.length-1);
	}
	private static void sortQuick(int[] a,int lo,int hi) {
		if (hi<=lo) {
			return;
		}
		int k=partition(a, lo, hi);
		sortQuick(a, lo, k-1);
		sortQuick(a, k+1, hi);
	}
	private static int partition(int[] a,int lo,int hi) {
		int i=lo;
		int j=hi+1;
		
		while(true) {
			while(a[++i]<a[lo]) if(i>=hi) break;
			while(a[--j]>a[lo]) if(j<=lo) break;
			if (i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	
	
	/*
	 * 选择排序
	 */
	public static void sortSelection(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min=i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j]<a[min]) {
					min=j;
				}
			}
			exch(a, i, min);
		}
	}
	
	/*
	 * 插入排序
	 */
	public static void sortInsertion(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j >0&&a[j]<a[j-1]; j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	/*
	 * 堆排序
	 */
	public static void sortHeap(int[] a) {
		int length=a.length;
		int[] heap=new int[length+1];
		for (int i = 0; i < length; i++) {
			heap[i+1]=a[i];
		}
		
		for (int i = length/2; i >=1; i--) {
			sink(heap, i, length);
		}
		
		int temp=length;
		while(temp>1) {
			exch(heap, 1, temp--);
			sink(heap, 1, temp);
		}
		
		for (int i = 0; i < length; i++) {
			a[i]=heap[i+1];
		}
		
	}
	/*
	 * 下沉
	 */
	private static void sink(int[] a,int k,int end) {
		while(2*k<=end) {
			int j=k*2;
			
			if (j<end&&a[j+1]>a[j]) {
				j++;
			}
			if (a[k]>a[j]) {
				break;
			}
			exch(a, k, j);
			
			k=j;
		}
	}
	/*
	 * 上浮
	 */
	public static void swim(int[] a,int k,int start) {
		while(k>1&&a[k/2]<a[k]) {
			exch(a, k/2, k);
			k=k/2;
		}
	}
	
	
	
	/*
	 * 交换次序
	 */
	private static void exch(int[] a,int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
