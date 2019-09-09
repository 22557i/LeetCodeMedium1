package lcwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution767 {
	public String reorganizeString(String S) {
		String res = "";
		if(S.length()<3)return S;
		int count[] = new int[26];
		int max = Integer.MIN_VALUE;
		for (char c:S.toCharArray()){
			count[c-'a']++;
		}
		for (int num : count) {
			max = Math.max(num,max);
		}
		if(max>(S.length()+1)/2)return res;
		char[] temp = S.toCharArray();
		for (int i = 0; i < temp.length-1; i++) {
			for (int j = 0; j <temp.length-1-i ; j++) {
				if(count[temp[i]-'a']<count[temp[j]-'a']){
					char tempchar = temp[i];
					temp[i] = temp[j];
					temp[j] = tempchar;
				}
			}
		}
		int n;
		n = (S.length() % 2 ==0 ?S.length()/2 :(S.length()+1)/2);
		for (int i = 0; i < n; i++) {
			res = res + temp[i];
			res = res + temp[i + n];
		}
		if(S.length() %2==1)res+=temp[n];
		return res;
	}
}
