package util;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0, r = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) {
            while(l < r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, set.size());
            r++;
        }
        return ans;


    }
}
