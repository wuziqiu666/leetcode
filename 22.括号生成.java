import java.util.*;
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.46%)
 * Likes:    2693
 * Dislikes: 0
 * Total Accepted:    523.1K
 * Total Submissions: 675.3K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        int l = n, r = 0;
        getBrackets(l, r, new StringBuilder());
        return ret;

    }
    
    void getBrackets(int l, int r, StringBuilder sBuilder) {
        if (l == 0 && r == 0) {
            ret.add(sBuilder.toString());
            return;
        }
        if (l != 0) {
            sBuilder.append('(');
            getBrackets(l - 1, r + 1, sBuilder);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
        if (r != 0) {
            sBuilder.append(')');
            getBrackets(l, r - 1, sBuilder);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
    } 
}
// @lc code=end

