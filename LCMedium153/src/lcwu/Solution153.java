package lcwu;

import java.util.Arrays;

public class Solution153 {
    public int findMin(int[] nums) {
        int res =0;
        int temp, previous;
        for (int i = 0; i < nums.length; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
            res=Math.min(res,nums[0]);
        }
        return res;
    }
}
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)return nums[0];
        if (nums[0]<nums[nums.length-1])return nums[0];
        int left = 0, right = nums.length - 1;
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid+1] < nums[mid ]) return nums[mid + 1];
            if (nums[mid] < nums[mid-1]) return nums[mid];
            if (nums[0] < nums[mid]) left = mid + 1;
            else right = mid - 1;

        }
        return -1;
    }
}