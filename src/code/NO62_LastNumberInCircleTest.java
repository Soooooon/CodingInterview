package code;

import java.util.ArrayList;
import java.util.List;

public class NO62_LastNumberInCircleTest {
	public static void main(String[] args) {
		//
		int n=0;
		int m=0;
		System.out.println(lastRemain(n, m));
		//
		
	}
	public static int lastRemain(int n,int m) {
		if (n==0) {
			return -1;
		}
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int index=0;
		while(list.size()>1) {
			index=(index+m-1)%list.size();
			System.out.println(list.get(index));
			list.remove(index);
		}
		return list.get(0);
	}
}
