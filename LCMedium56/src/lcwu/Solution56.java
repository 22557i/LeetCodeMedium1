package lcwu;

import java.util.*;

public class Solution56 {
	public int[][] merge(int[][] intervals) {
		List<int[]> res=new ArrayList<int[]>();
		if(intervals==null||intervals.length==0){
			return res.toArray(new int[res.size()][]);
		}
		Arrays.sort(intervals,(a,b)->(a[0]-b[0]));

		int[] c=intervals[0];
		for(int[] n:intervals){
			if(n[0]<=c[1]&&n[1]>c[1]){
				c[1]=n[1];
			}else if(n[0]>c[1]){
				res.add(c);
				c=n;
			}
		}
		res.add(c);

		return res.toArray(new int[res.size()][]);
	}
}
