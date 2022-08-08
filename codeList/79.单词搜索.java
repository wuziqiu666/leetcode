import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode.cn/problems/word-search/description/
 *
 * algorithms
 * Medium (46.40%)
 * Likes:    1400
 * Dislikes: 0
 * Total Accepted:    349.7K
 * Total Submissions: 753.6K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 
 * 1 
 * board 和 word 仅由大小写英文字母组成
 * 
 * 
 * 
 * 
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        char letter = wordArray[0];
        int n = board.length;
        int m = board[0].length; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == letter) {
                    board[i][j] = '-';
                    int[] site = { i, j };
                    if (getNextSite(board, wordArray, 1, site)) {
                        return true;
                    }
                    board[i][j] = letter;

                }
            }
        }
        return false;
    }

    public boolean getNextSite(char[][] board, char[] wordArray, int charSite, int[] site) {
        if (charSite == wordArray.length) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        int x = site[0];
        int y = site[1];
        char letter = wordArray[charSite];
        int[] nextX = {1, 0, -1, 0};
        int[] nextY = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int tmpx = x + nextX[i];
            int tmpy = y + nextY[i];
            if (tmpx >= 0 && tmpx < n && tmpy >= 0 && tmpy < m && board[tmpx][tmpy] == letter) {
                int[] next = { tmpx, tmpy };
                board[tmpx][tmpy] = '-';
                if (getNextSite(board, wordArray, charSite + 1, next)) {
                    return true;
                }
                board[tmpx][tmpy] = letter;
            }
        }
        return false;
    }
}
// @lc code=end

