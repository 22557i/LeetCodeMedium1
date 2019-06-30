package lcwu;

public class Solution842 {

    public String shiftingLetters(String S, int[] shifts) {
        int total = 0;
        char[] chars = S.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            total = (total + shifts[i]) % 26;
            chars[i] += total;
            if (chars[i] > 'z') {
                chars[i] += 'a'- 1 - 'z' ;
            }
        }
        return new String(chars);
    }
}
