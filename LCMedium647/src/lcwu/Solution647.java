package lcwu;

public class Solution647 {
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int length = s.length();
		int count = 0;
		for (int len = 2; len <= length; len++)
		{
			for (int i = 0; i < length - len + 1; i++)
			{
				int j = i + len - 1;
				if (isPalindrome(s, i, j))
				{
					count++;
				}
			}
		}
		return count + s.length();
	}

	private boolean isPalindrome(String s, int i, int j)
	{
		int l = i;
		int r = j;

		while (l <= r)
		{
			if (s.charAt(l) != s.charAt(r))
			{
				return false;
			}

			l++;
			r--;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution647 s647 = new Solution647();
		String s = "abc";
		s647.countSubstrings(s);

	}
}
//	private boolean isPalindrome(String s, int i, int j)
//	{
//		int l = i;
//		int r = j;
//
//		while (l <= r)
//		{
//			if (s.charAt(l) != s.charAt(r))
//			{
//				return false;
//			}
//
//			l++;
//			r--;
//		}
//
//		return true;
//	}