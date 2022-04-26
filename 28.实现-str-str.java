/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (40.33%)
 * Likes:    1397
 * Dislikes: 0
 * Total Accepted:    629K
 * Total Submissions: 1.6M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0
 * 开始）。如果不存在，则返回  -1 。
 * 
 * 
 * 
 * 说明：
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf()
 * 定义相符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：haystack = "", needle = ""
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int n = needle.length();
        int m = haystack.length();

        int[] next = new int[n];
        next[0] = -1;
        int i = -1;
        int j = 0;
        while (j < n - 1) {
            if (i == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[j] = i;
            } else {
                i = next[i];
            }
        }
        
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (i == -1 || needle.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }
        if (i == n) {
            return j - n;
        } else {
            return -1;
        }

    }
}
// @lc code=end

