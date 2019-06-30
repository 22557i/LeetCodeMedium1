package lcwu;

public class Solution1004 {
    public int longestOnes(int[] nums, int K) {
        if(nums.length<1) return 0;
        int sum =0;
        int max=0;
        int countzero=0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j <nums.length&&countzero<=K ; j++) {
                if(nums[j]!=1){
                    countzero++;
                    count++;

                }else {
                    count++;
                }
            }
            max = Math.max(max, count);
            sum=Math.max(max,count);
            count = 0;
            countzero = 0;

        }

        return sum;
    }

    public int longestOnes1(int[] A, int K) {
        int count = 0, max = 0, countzero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) count++;
            else if (countzero < K) {
                count++;
                countzero++;
            } else {
                int start = i - count;
                while (A[start++] != 0) {
                    count--;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}