public class Solution396 {
	public int maxRotateFunction(int[] A) {
		long a = 0, b = 0, res = 0, t = 0, f0 = 0;
		int n = A.length;
		for (int i = 0; i < n; i++)
		{
			a += A[i];
			f0 += i * A[i];
		}
		for (int k = 1; k < n; k++)
		{
			b += A[n - k];
			t = k * a - n * b;
			res = t > res ? t : res;
		}
		return (int)(f0 + res);
	}
	public void rotate(int []A){
		int temp = A[A.length-1];
		for (int i = A.length-1; i >0 ; i--) {
			A[i]=A[i-1];
		}
		A[0] = temp;
	}

	public static void main(String[] args) {
		int []a = new int[]{4,3,2,6};
		Solution396 a4 = new Solution396();
		a4.rotate(a);
		for(int c :a){
			System.out.println(c);
		}
	}
}
