package lcwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution215 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
