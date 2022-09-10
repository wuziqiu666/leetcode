import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{matrix[i][0], i, 0});
        }
        while (queue.size() != 0 && k > 0) {
            int[] tmp = queue.poll();
            ans = tmp[0];
            if(tmp[2] < m - 1){
                queue.offer(new int[]{matrix[tmp[1]][tmp[2] + 1], tmp[1], tmp[2] + 1});
            }
            k--;
        } 
        return ans;
    }
}
// @lc code=end
