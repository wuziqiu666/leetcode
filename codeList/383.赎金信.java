/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(char c : magazine.toCharArray()){
            cnt[c - 'a'] += 1;
        }
        for(char c : ransomNote.toCharArray()){
            cnt[c - 'a'] -= 1;
            if(cnt[c - 'a'] < 0){
                return false;
            }
        }
        return true;

    }
}
// @lc code=end

