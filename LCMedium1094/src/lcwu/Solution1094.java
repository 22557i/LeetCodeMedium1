package lcwu;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1094 {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] count= new int[1001];
		for(int[] t :trips){
			count[t[1]]+=t[0];
			count[t[2]]-=t[0];
		}

		if(count[0]>capacity)return false;
		for (int i = 1; i < count.length; i++) {
			count[i]+=count[i-1];
			if(count[i]>capacity)return false;
		}
		return true;
	}
	public void sortstartlocation(int [][]trips){
		Arrays.sort(trips,(a1,a2)-> {return a1[1]-a2[1];});

	}

	public static void main(String[] args) {
		int trips[][]={{3,2,7},{3,7,9},{8,3,9}};
		Arrays.sort(trips,(a1,a2)-> {return a1[1]-a2[1];});
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3 ; j++) {
				System.out.print(trips[i][j]);
			}
			System.out.println();
		}

	}
}
