package lcwu;

import java.util.Arrays;

public class Solution435 {
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length<2)return 0;
		int res =0;
		Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
		int idx = intervals[0][1];
		for (int i =1; i < intervals.length; i++) {
			if(intervals[i][0]>=idx)idx = intervals[i][1];
			else res++;
		}
		return res;
	}
}
