import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 *
 * https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (50.84%)
 * Likes:    679
 * Dislikes: 0
 * Total Accepted:    109.7K
 * Total Submissions: 215.8K
 * Testcase Example:  '"abab"'
 *
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "aba"
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] next = new int[s.length()];
        Arrays.fill(next, -1);
        for(int j = 1; j < s.length(); j++){
            int i = next[j - 1];
            while (i != -1 && s.charAt(i + 1) != s.charAt(j)) {
                i = next[i];
            }
            if (s.charAt(i + 1) == s.charAt(j)) {
                next[j] = i + 1;
            }
        }
        return next[n - 1] != -1 && n % (n - next[n - 1] - 1) == 0;
    }
}

// @lc code=end
