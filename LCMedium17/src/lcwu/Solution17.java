package lcwu;
import java.util.*;

	class Solution17 {
		String[] letterMap = {
				" ", //0
				"", //1
				"abc",//2
				"def",//3
				"qhi",//4
				"jkl",//5
				"mno",//6
				"pqrs",//7
				"tuv",//8
				"wxyz"//9

		};

		List<String> res = new LinkedList<>();
		public List<String> letterCombinations(String digits) {
			res.clear();
			if (digits == "") return new LinkedList<>();
			findCombination(digits, 0, "");
			return res;
		}
		//s中保存了此时从digits[0....index-1]
		private void findCombination(String digits, int index, String s){
			if (index == digits.length()){
				//保存s
				res.add(s);
				return;
			}
			char c = digits.charAt(index);
			assert (c >= '0' && c <= '9' && c != '1');
			String letters = letterMap[c - '0'];
			for (int i = 0; i < letters.length(); i++){
				findCombination(digits, index+1, s+letters.charAt(i));
			}

			return;
		}

	}