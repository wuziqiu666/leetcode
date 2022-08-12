/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode.cn/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (45.85%)
 * Likes:    844
 * Dislikes: 0
 * Total Accepted:    191.3K
 * Total Submissions: 416.9K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X'
 * 填充。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 
 * board[i][j] 为 'X' 或 'O'
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'I';
                }   
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'I') {
                board[i][0] = 'O';
                expand(board, i, 0);
            }
            if (board[i][m - 1] == 'I') {
                board[i][m - 1] = 'O';
                expand(board, i, m - 1);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'I') {
                board[0][j] = 'O';
                expand(board, 0, j);
            }
            if (board[n - 1][j] == 'I') {
                board[n - 1][j] = 'O';
                expand(board, n - 1, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'I') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void expand(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (i > 0 && board[i - 1][j] == 'I') {
            board[i - 1][j] = 'O';
            expand(board, i - 1, j);
        }
        if (i < n - 1 && board[i + 1][j] == 'I') {
            board[i + 1][j] = 'O';
            expand(board, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'I') {
            board[i][j - 1] = 'O';
            expand(board, i, j - 1);
        }
        if (j < m - 1 && board[i][j + 1] == 'I') {
            board[i][j + 1] = 'O';
            expand(board, i, j + 1);
        }
    }
}
// @lc code=end

