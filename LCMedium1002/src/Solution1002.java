import java.util.*;
public class Solution1002 {
	public List<String> commonChars(String[] A) {
		int[] chars = new int[26];
		int[] totalchars = new int[26];
		List<String> res = new ArrayList();
		Arrays.fill(totalchars, Integer.MAX_VALUE);
		for (String str : A) {
			for (int i = 0; i < str.length(); i++) {
				chars[str.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				totalchars[i] = Math.min(totalchars[i], chars[i]);
				chars[i] = 0;
			}
		}
		for (int i = 0; i < 26; i++) {
			while ((totalchars[i]--) > 0) {
				res.add(String.valueOf((char)('a' + i)));
			}
		}
		return res;
	}
}
