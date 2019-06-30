package lcwu;

import java.util.Arrays;

public class Solution560 {
	public int subarraySum(int[] nums, int k) {
		for (int i = 0; i <nums.length ; i++) {
			for (int j = i+1; j <nums.length ; j++) {

				if(Arrays.stream(Arrays.copyOfRange(nums,i,j)).sum()==k){
					return j-i;
				}
			}
		}
		return 0;
	}
}
