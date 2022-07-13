/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (36.73%)
 * Likes:    5308
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.9M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String ret = s.substring(0, 1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int len = 0;
            while (i - len >= 0 && i + len < n && s.charAt(i - len) == s.charAt(i + len)) {
                len++;
            }
            len--;
            if (len * 2 + 1 > ret.length()) {
                ret = s.substring(i - len, i + len + 1);
            }

            len = 1;
            while (i - len + 1 >= 0 && i + len < n && s.charAt(i - len + 1) == s.charAt(i + len)) {
                len++;
            }
            len--;
            if (2 * len > ret.length()) {
                ret = s.substring(i - len + 1, len + i + 1);
            }
        }
        return ret;

    }
}
// @lc code=end

