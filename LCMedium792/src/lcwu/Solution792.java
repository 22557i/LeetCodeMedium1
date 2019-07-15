package lcwu;

public class Solution792 {
	public int numMatchingSubseq(String S, String[] words) {
		int index = -1;
		int count = 0;
		boolean notSubSeq = true;
		for(String word : words) {
			for(char c : word.toCharArray()) {
				index = S.indexOf(c, index + 1);
				if (index == -1) {
					notSubSeq = false;
					break;
				}
			}
			if(notSubSeq)
				count++;
				notSubSeq = true;
				index = -1;
		}
		return count;
	}
}
