package lcwu;

public class Solution214 {

	public String shortestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		String res = new String();
		for (int i = 0; i <s.length() ; i++) {
			for (int j = i+1; j <=s.length() ; j++) {
				String temp = s.substring(i,j);
				if(temp.equals(reverseString(temp))){
					if(res.length()<=temp.length())
						res=temp;
				}
			}

		}
		return res;

	}
	String reverseString(String s) {
		StringBuilder input1 = new StringBuilder();
		input1.append(s);
		input1 = input1.reverse();
		return input1.toString();
	}
	public boolean isp(String s){
		return (s.equals(reverseString(s)))?true:false;
	}
}
