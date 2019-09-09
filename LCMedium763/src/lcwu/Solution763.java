package lcwu;

import java.util.*;
public class Solution763 {
	public List<Integer> partitionLabels(String S) {
		LinkedList<Integer>res = new LinkedList<>();
		if(S.length()==0)return res;
		char[]temp = S.toCharArray();
		Arrays.sort(temp);

		int []list = new int[26];
		for(int i=0;i<S.length();i++){
			list[S.charAt(i)-'a']=i;
		}
		int j =0;
		int anchor =0;
		for (int i = 0; i <temp.length ; ++i) {
			j=Math.max(j,list[S.charAt(i)-'a']);
			if(i==j){
				res.add(i-anchor+1);
				anchor = i+1;
			}
		}
		return res;
	}
}
