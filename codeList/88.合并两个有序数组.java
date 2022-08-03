/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        n = n - 1;
        m = m - 1;
        for (int i = nums1.length - 1; i >= 0 && n >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n];
                n--;
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m];
                    m--;
                } else {
                    nums1[i] = nums2[n];
                    n--;
                }
            }
        }
    }
}
// @lc code=end
