import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (58.30%)
 * Likes:    1851
 * Dislikes: 0
 * Total Accepted:    533.1K
 * Total Submissions: 912.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    class UnionFind {
        public int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int ni = grid.length;
            int nj = grid[0].length;
            rank = new int[ni * nj];
            parent = new int[ni * nj];
            Arrays.fill(rank, 0);
            for (int i = 0; i < ni; i++) {
                for (int j = 0; j < nj; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[i * nj + j] = i * nj + j;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if (roota != rootb) {
                if (rank[roota] > rank[rootb]) {
                    parent[rootb] = roota;
                } else if (rank[roota] < rank[rootb]) {
                    parent[roota] = rootb;
                } else {
                    parent[rootb] = roota;
                    rank[roota]++;
                }
                count--;
            }
        }

    }

    public int numIslands(char[][] grid) {
        UnionFind find = new UnionFind(grid);
        int[][] nextValue = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ni = grid.length;
        int nj = grid[0].length;
        for (int i = 0; i < ni; i++) {
            for (int j = 0; j < nj; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int nexti = i + nextValue[k][0];
                        int nextj = j + nextValue[k][1];
                        if (nexti >= 0 && nexti < ni && nextj >= 0
                                && nextj < nj && grid[nexti][nextj] == '1') {
                            find.union(i * nj + j, (nexti) * nj + nextj);
                            // System.out.println("i"+ i);
                            // System.out.println("j" + j);
                            // System.out.println("nexti" + (nexti));
                            // System.out.println("nextj" + (nextj));
                            // System.out.println(find.count);

                        }
                    }
                }
            }
        }
        return find.count;

    }

}
// @lc code=end
