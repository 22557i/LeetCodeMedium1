package lcwu;

public class Solution34 {
	public int[] searchRange(int[] nums, int target) {
		int begin=-1;
		int end = -1;
		for (int i = 0; i <nums.length ; i++) {
			if(nums[i]==target){
				begin=i;
				break;
			}
		}
		for (int i = nums.length-1; i>-1; i--) {
			if(nums[i]==target){
				end = i;
				break;
			}
		}
		return new int[]{begin,end};
	}

}
