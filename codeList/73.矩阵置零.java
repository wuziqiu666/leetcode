import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (62.20%)
 * Likes:    755
 * Dislikes: 0
 * Total Accepted:    203.1K
 * Total Submissions: 326.5K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        long[] row = { 0, 0, 0, 0 };
        long[] column = { 0, 0, 0, 0 };
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    int site1 = i / 64;
                    long site2 = (long)1 << (i % 64);
                    row[site1] = row[site1] | site2;
                    site1 = j / 64;
                    site2 = (long)1 << (j % 64);
                    column[site1] = column[site1] | site2;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < 64; j++) {
                if ((row[i] & ((long)1 << j)) != 0) {
                    Arrays.fill(matrix[i * 64+ j], 0);
                }
            }
        }
        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < 64; j++) {
                if ((column[i] & ((long)1 << j)) != 0) {
                    for (int k = 0; k < n; k++) {
                        matrix[k][i * 64 + j] = 0;
                    }

                }
            }
        }

    }
}
// @lc code=end

