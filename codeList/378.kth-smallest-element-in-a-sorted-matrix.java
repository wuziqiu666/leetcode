/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    int[][] matrix;
    int n;
    int m;

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[n - 1][m - 1];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int t, int k) {
        int i = n - 1;
        int j = 0;
        int nums = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] <= t) {
                nums += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return nums >= k;
    }
}
// @lc code=end
