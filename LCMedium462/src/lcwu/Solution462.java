package lcwu;

import java.util.Arrays;

public class Solution462 {
	public int minMoves2(int[] nums) {
		if(nums.length==0)return nums.length;
		Arrays.sort(nums);
		int n =nums.length/2;
		int a=0;
		int b=0;

		for (int i = 0; i <nums.length ; i++) {
			a+=Math.abs(nums[n]-nums[i]);
			if(n>0)b+=Math.abs(nums[n-1]-nums[i]);
		}
		return Math.min(a,b);
	}
}
