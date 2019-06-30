package lcwu;

import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1))return 1;
            else return 2;
        }
        int res=0;
        for(int i=0;i<s.length();i++)
            for(int j=i+1;j<=s.length();j++){
                if(isrepeated(s.substring(i,j)))res=Math.max(res,j-i);
            }


        return res;
    }
    public boolean isrepeated(String s){
        Set a = new HashSet();
        for(int i =0;i<s.length();i++){
            a.add(s.charAt(i));
        }
        return (a.size()==s.length())?true:false;
    }
}
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }