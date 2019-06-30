package lcwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int resall =Arrays.stream(nums).sum();
        if(resall>s)return 0;
        if(resall==s)return nums.length;

        Stack<int[]> stacklist = new Stack<>();
        stacklist.add(nums);
        printall(nums);
        ArrayList reslist = new ArrayList();
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++){
                int temp[]=subArray(nums,i,j);
                printall(temp);
                if(Arrays.stream(temp).sum()>s){
                    if(temp.length<stacklist.peek().length)stacklist.push(temp);
                }
            }
        printall(stacklist.peek());
        return stacklist.peek().length;
    }

    public int[] subArray(int[]nums,int start,int end){
        int res[] = new int[end-start+1];
        for(int i=0;i<res.length;i++)
            res[i]=nums[i+start];
        return res;
    }

    public void printall(int []nums){
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]+"-");
        System.out.println("");

    }

    public static void main(String[] args) {
        int[]test = {2,3,1,2,4,3};
        Solution209 s209= new Solution209();
        s209.minSubArrayLen(7,test);
    }
}
//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        int ans = Integer.MAX_VALUE;
//        int left = 0;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            while (sum >= s) {
//                ans = Math.min(ans, i + 1 - left);
//                sum -= nums[left++];
//            }
//        }
//        return (ans != Integer.MAX_VALUE) ? ans : 0;
//    }