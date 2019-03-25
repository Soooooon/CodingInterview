package code;

import java.util.Arrays;

public class NO53_SearchNumsTest {
	public static void main(String[] args) {
		//
//		int[] nums= {5,7,7,8,8,10};
//		int target=6;
//		System.out.println(searchFirst(nums, target));
//		System.out.println(searchLast(nums, target));
//		System.out.println(Arrays.toString(searchRange_method2(nums, target)));
		//
//		int[] nums= {0,1,2,3,4,6};
//		System.out.println(findMissNum(nums));
		//
		int[] nums= {-3,-1,1,3,5};
		System.out.println(findValueEqualIndex(nums));
	}
	public static int[] searchRange_method1(int[] nums,int target) {
		int[] range= {-1,-1};
		
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==target) {
				count++;
			} else if (count!=0&&nums[i]!=target) {
				break;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==target) {
				range[0]=i;
				break;
			}
		}
		
		if (count!=0) {
			range[1]=range[0]+count-1;			
		}
		return range;
	}
	
	/*
	 * 二分查找
	 */
	public static int[] searchRange_method2(int[] nums,int target) {
		int[] range=new int[2];
		
		range[0]=searchFirst(nums, target);
		range[1]=searchLast(nums, target);
		
		return range;
	}
	
	public static int searchFirst(int[] nums,int target) {
		int length=nums.length;
		
		int start=0;
		int end=length-1;
		int middle;
		
		while(start<end) {
			middle=(start+end)/2;
			
			if (nums[middle]<target) {
				start=middle+1;
			} else if (nums[middle]>target) {
				end=middle;
			} else {
				if (middle==0||nums[middle-1]!=target) {
					end=middle;
					break;
				} else {
					end=middle;
				}
			}
		}
		if (nums[end]==target) {
			return end;			
		} else {
			return -1;
		}
	}
	public static int searchLast(int[] nums,int target) {
		int length=nums.length;
		
		int start=0;
		int end=length-1;
		int middle;
		
		while(start<end) {
			middle=(start+end)/2;
			
			if (nums[middle]>target) {
				end=middle;
			} else if (nums[middle]<target) {
				start=middle+1;
			} else {
				if (nums[middle+1]!=target) {
					end=middle;
					break;
				} else {
					start=middle+1;
				}
			}
		}
		if (nums[end]==target) {
			return end;			
		} else {
			return -1;
		}
	}
	
	
	public static int findMissNum(int[] nums) {
		int length=nums.length;
		
		int start=0;
		int end=length-1;
		int middle;
		while(start<end) {
			middle=(start+end)/2;
			if (nums[middle]==middle) {
				start=middle+1;
			} else {
				end=middle;
			}
		}
		if (nums[end]==end) {
			return end+1;
		} else {
			return end;			
		}
		
	}
	
	
	
	public static int findValueEqualIndex(int[] nums) {
		int length=nums.length;
		
		int start=0;
		int end=length-1;
		int middle;
		
		while(start<end) {
			middle=(start+end)/2;
			if (nums[middle]>middle) {
				end=middle;
			} else if (nums[middle]<middle) {
				start=middle+1;
			} else {
				return middle;
			}
		}
		return end;
	}
}
