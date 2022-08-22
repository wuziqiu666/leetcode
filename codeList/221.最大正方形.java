/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode.cn/problems/maximal-square/description/
 *
 * algorithms
 * Medium (49.11%)
 * Likes:    1241
 * Dislikes: 0
 * Total Accepted:    222.7K
 * Total Submissions: 453K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：matrix = [["0"]]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * matrix[i][j] 为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] == 1) {
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] == 1) {
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int nextSize = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    dp[i][j] = nextSize;
                    max = Math.max(nextSize, max);
                }
            }
        }
        return max * max;

    }
}
// @lc code=end
