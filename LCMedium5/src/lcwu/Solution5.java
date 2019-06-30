package lcwu;

public class Solution5 {

    public String longestPalindrome(String s) {
        if(s.length()<2)return s;
        if(s.length()==2){
            if(s.charAt(0)!=s.charAt(1))return s.substring(0,1);
            else return s;
        }
        String []sD =new String[s.length()];
        int res=0;
        for(int i=0;i<s.length();i++)
            for(int j=i+1;j<=s.length();j++){
                if(isP(s.substring(i,j)))sD[j-i]=s.substring(i,j);
            }
        for(int k = s.length()-1;k>-1;k--)
            if(sD[k]!=null)return sD[k];

            return null;
    }
    public boolean isP(String s){
        StringBuffer a = new StringBuffer(s).reverse();
        return (a.toString().equals(s));
    }
}
//    public String longestPalindrome(String s) {
//        int size = s.length();
//        int maxLength = 0;
//        int pos = 0;
//        char[] arr = s.toCharArray();
//        for(int i = 0; i < size && size - i > maxLength; i++){
//            for(int len = size - i; len > 0 && len > maxLength; len--){
//                if(equals(arr, i, i + len)) {
//                    maxLength = len;
//                    pos = i;
//                }
//            }
//        }
//        return s.substring(pos, maxLength + pos);
//    }
//
//    //*** True - if subarray (from start to end) is palindromic
//    private boolean equals(char[] arr, int start, int end){
//        final int half = (start + end) / 2;
//        for(int i = start, k = end - 1; i < half; i++, k--){
//            if(arr[i] != arr[k])
//                return false;
//        }
//        return true;
//    }
