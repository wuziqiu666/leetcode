/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 *
 * https://leetcode.cn/problems/permutation-sequence/description/
 *
 * algorithms
 * Hard (53.20%)
 * Likes:    693
 * Dislikes: 0
 * Total Accepted:    112.4K
 * Total Submissions: 211.3K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3, k = 3
 * 输出："213"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 3, k = 1
 * 输出："123"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = (char) ('0' + i + 1);
        }
        for (int i = 0; i < k - 1; i++) {
            getNextSeq(chars);
        }
        return new String(chars);
        

    }

    /**
     * 1 2 3 4
     * 1 2 4 3
     * 1 3 2 4
     * 1 3 4 2
     * 1 4 2 3
     * 1 4 3 2
     * 
     */
    public void getNextSeq(char[] seq) {
        int n = seq.length;
        int a = n - 2;
        while (a > 0 && seq[a + 1] <= seq[a]) {
            a--;
        }
        if (a >= 0) {
            for (int b = n - 1; b > 0; b--) {
                if (seq[b] > seq[a]) {
                    swap(seq, a, b);
                    break;
                }
            }
        }
        reverse(seq, a + 1, n - 1);
    }
    
    public void swap(char[] seq, int a, int b) {
        char tmp = seq[a];
        seq[a] = seq[b];
        seq[b] = tmp;
    }

    public void reverse(char[] seq, int l, int r) {
        while (l < r) {
            swap(seq, l, r);
            l++;
            r--;
        }
    }
}
// @lc code=end
