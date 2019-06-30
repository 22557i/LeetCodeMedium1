package lcwu;

public class Solution387 {
	public int firstUniqChar(String s) {
		int [] res=new int[26];
		for(int i=0;i<s.length();i++){
			res[s.charAt(i)-'a']++;
		}
		for(int j=0;j<s.length();j++)
		{
			if(res[s.charAt(j)-'a']==1) return j;
		}
		return -1;

	}
}
