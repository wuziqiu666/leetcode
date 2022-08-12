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
    boolean[][] f;
    List<List<String>> ans;
    String s;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        this.s = s;
        int n = s.length();
        this.f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        searchPart(new ArrayList<>(), 0);
        return ans;

    }

    public void searchPart(List<String> list, int site) {
        int n = s.length();
        if (site == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        int l = site, r = site;
        while (l >= 0 && r < n) {
            if (f[l][r]) {
                list.add(s.substring(l, r + 1));
                searchPart(list, r + 1);
                list.remove(list.size() - 1);
            }
            r++;
        }
        
    }
}
// @lc code=end

