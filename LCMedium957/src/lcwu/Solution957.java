package lcwu;

public class Solution957 {
	public int[] prisonAfterNDays(int[] cells, int N) {
		int []temp = new int[8];
		int d = 0;
		N = N % 14 == 0 ? 14 : N % 14;
		while(d<N){
			for (int i = 1; i <7 ; i++) {
				if(cells[i+1]==cells[i-1]) {
					temp[i]=1;
				}
				else temp[i]=0;
			}
			cells = temp.clone();
			d++;
		}
		return cells;
	}
}
