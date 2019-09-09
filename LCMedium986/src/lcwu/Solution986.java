package lcwu;


import java.util.*;
public class Solution986 {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		ArrayList<int[]>list = new ArrayList<>();
		int i=0;
		int j =0;
		while(i<A.length && j <B.length) {
			int start = Math.max(A[i][0], B[j][0]); 
			int end = Math.min(A[i][1], B[j][1]); 
			if(start <= end) {
				list.add(new int[]{start,end});
			}
			if(A[i][1]>B[j][1]) { 
				j++;
			} else {
				i++;
			}
		}
		int[][] res = new int[list.size()][2];
		for (int k = 0; k < list.size(); k++) {
			res[k][0] = list.get(k)[0];
			res[k][1] = list.get(k)[1];
		}
		return res;
	}
}
