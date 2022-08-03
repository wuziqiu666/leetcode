/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);
        StringBuilder sBuilder = new StringBuilder(s);
        return s.equals(sBuilder.reverse().toString());
    }
}
// @lc code=end

