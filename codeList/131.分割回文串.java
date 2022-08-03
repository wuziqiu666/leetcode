import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (72.75%)
 * Likes:    1089
 * Dislikes: 0
 * Total Accepted:    184.7K
 * Total Submissions: 253.9K
 * Testcase Example:  '"aab"'
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 
 * 回文串 是正着读和反着读都一样的字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "a"
 * 输出：[["a"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    int n;
    boolean[][] dp;
    List<List<String>> ret;
    List<String> ans;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[s.length()][s.length()];
        ret = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int site) {
        if (site == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = site; i < s.length(); i++) {
            if (dp[site][i]) {
                ans.add(s.substring(site, i + 1));
                dfs(s,i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
// @lc code=end
