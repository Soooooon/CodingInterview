package code;

public class NO61_ContinousCardsTest {
	public static void main(String[] args) {
		//
		int[] numbers= {0,10,11,12,13};
		//
		System.out.println(isContinuous(numbers));
	}
	public static boolean isContinuous(int[] numbers) {
		int[] cards=new int[14];
		
		for(int card:numbers) {
			cards[card]++;
		}
		
		int count=0;
		
		for (int begin = 1; begin <= 9; begin++) {
			if (cards[begin]!=0) {
				for (int i = begin+1; i < begin+5; i++) {
					if (cards[i]==0) {
						count++;
					}
				}
				break;
			} else if (cards[begin]==0&&begin==9) {
				count++;
				for (int i = begin+1; i < begin+5; i++) {
					if (cards[i]==0) {
						count++;
					}
				}
				break;
			}
		}
		if (count==cards[0]) {
			return true;
		} else {
			return false;
		}
	}
}
