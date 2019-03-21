package code;

public class NO51_InversePairsTest {
	public static void main(String[] args) {
		//
		int[] array= {7,5,6,4};
		//
		System.out.println(inversePairs_method2(array));
	}
	public static int inversePairs_method1(int[] array) {
		int count=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i]>array[j]) {
					count++;
				}
			}
		}
		return count;
	}
	public static int inversePairs_method2(int[] array) {
		return dfs(array, array.clone(), 0, array.length-1);
	}
	private static int dfs(int[] array, int[] copy,int start,int end) {
		if (start==end) {
			return 0;
		}
		int count=0;

		int middle=(start+end)/2;
		
		int left=dfs(array, copy, start, middle)%1000000007;
		int right=dfs(array, copy, middle+1, end)%1000000007;
		
		int i=middle;
		int j=end;
		
		int index=end;
		while(i>=start&&j>middle) {
			
			if (array[i]>array[j]) {
				copy[index--]=array[i--];
				count+=j-middle;
				count=count>=1000000007?count%1000000007:count;
			} else {
				copy[index--]=array[j--];
			}
			
		}
		while(i>=start) copy[index--]=array[i--];
		while(j>middle) copy[index--]=array[j--];
		
		for (int k = start; k <= end; k++) {
			array[k]=copy[k];
		}
		return (left+count+right)%1000000007;
	}
}
