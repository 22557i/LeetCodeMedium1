package lcwu;

public class Solution11 {
    public int maxArea(int[] height) {
        int res=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                res=Math.max(res,Math.min(height[i],height[j])*(j-i));
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution11 s11 = new Solution11();
        int test[] = {2,3,10,5,7,8,9};
        s11.maxArea(test);
    }
}
