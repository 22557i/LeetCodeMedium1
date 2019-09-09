package lcwu;

public class Solution264 {
	public int nthUglyNumber(int n) {
		int count=0;
		int i;
		for (i = 1;count<=n  ;i++ ) {
			if(isUgly(i))count++;
			if(count==n)break;
		}
		return i;
	}
	public boolean isUgly(int num) {
		if(num==0)return false;
		if (num==1||num==2||num==3||num==5) return true;
		if(num%2==0) return isUgly(num/2);
		if(num%3==0) return isUgly(num/3);
		if(num%5==0) return isUgly(num/5);

		return false;
	}
}
//	int i1,i2,i3;
//	public int nthUglyNumber(int n) {
//		int[] dp = new int[n];
//		dp[0] = 1;
//		for(int i=1;i<n;i++){
//			int a = dp[i1]*2;
//			int b = dp[i2]*3;
//			int c = dp[i3]*5;
//
//			dp[i] = Math.min(a,Math.min(b,c));
//
//			if(dp[i] == a){
//				i1++;
//			}
//			if(dp[i] == b){
//				i2++;
//			}
//			if(dp[i] == c){
//				i3++;
//			}
//		}
//		return dp[n-1];
//	}