package lcwu;

public class Solution29 {
	public int divide(int dividend, int divisor) {

		if(dividend==0) return 0;

		if(divisor==1) return dividend;

		if(divisor==-1)
			return (dividend==Integer.MIN_VALUE ? Integer.MAX_VALUE: -dividend);

		boolean isNeg = (divisor<0 && dividend>0) || (divisor>0 && dividend<0);

		//Math.abs() method - Note that if the argument is equal to the value of Long.MIN_VALUE, the most negative representable long value, the result is that same value, which is negative.
		//So you have to cast to `long` before `.abs` method, or you still get Integer.MIN_VALUE as it is (the negative number: -2147483648)
		long dividendL = Math.abs((long)dividend);
		long divisorL = Math.abs((long)divisor);

		int ans = (int)getQuotient(dividendL, divisorL);

		if(isNeg) return -ans;
		return ans;
	}

	private long getQuotient(long dividendL, long divisorL) {

		if(dividendL<divisorL) return 0;

		long sum = divisorL;
		long count = 1;
		while(dividendL >= (sum+sum)) {
			sum += sum;
			count += count;
		}
		return count + getQuotient(dividendL-sum,divisorL);
	}
}
