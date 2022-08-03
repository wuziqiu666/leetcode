import java.util.*;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int a, b;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            a = intervals[i][0];
            b = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < a) {
                list.add(new int[] { a, b });
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], b);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
// @lc code=end
