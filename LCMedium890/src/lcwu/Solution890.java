package lcwu;
import java.util.*;
public class Solution890 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List <String> res = new LinkedList<>();
		for(String word:words){
			if(ismatch(word ,pattern))res.add(word);
		}
		return res;
	}
	public boolean ismatch(String word, String pattern) {
		Map<Character, Character> m1 = new HashMap();
		Map<Character, Character> m2 = new HashMap();

		for (int i = 0; i < word.length(); ++i) {
			char w = word.charAt(i);
			char p = pattern.charAt(i);
			if (!m1.containsKey(w)) m1.put(w, p);
			if (!m2.containsKey(p)) m2.put(p, w);
			if (m1.get(w) != p || m2.get(p) != w)
				return false;
		}

		return true;
	}
}
