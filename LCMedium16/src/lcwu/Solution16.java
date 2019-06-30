package lcwu;
import java.util.*;
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 0;
        int res = nums[0] + nums[1] + nums[nums.length-1];
        for(int i = 0; i < nums.length-2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                min = nums[i] + nums[left] + nums[right];
                if(min > target)right--;
                if(min < target)left++;
                if(min == target)return min;
                if(Math.abs(min - target) < Math.abs(res - target))res = min;
            }
        }
        return res;
    }
}
