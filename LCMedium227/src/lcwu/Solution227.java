package lcwu;

public class Solution227 {
	public int calculate(String s) {
		int idx = 0, op = -1;
		long val = 0, prev= 0;

		while(idx < s.length()) {
			while(idx < s.length() && s.charAt(idx) == ' ') idx++;
			if(idx == s.length()) break;

			if(Character.isDigit(s.charAt(idx))) {
				op = -1;
			} else {
				op = idx;
				idx++;
				while(s.charAt(idx) == ' ') idx++;
			}

			int start = idx;
			while(idx < s.length() && Character.isDigit(s.charAt(idx))) idx++;
			long v = Long.valueOf(s.substring(start, idx));

			if(op == -1) {
				prev = v;
			} else if(s.charAt(op) == '+') {
				prev = v;
			} else if(s.charAt(op) == '-') {
				prev = -v;
			} else if(s.charAt(op) == '*') {
				val -= prev;
				prev = prev*v;
			} else if(s.charAt(op) == '/') {
				val -= prev;
				prev = prev/v;
			}
			val += prev;
		}

		return (int)val;
	}
}
