import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (64.71%)
 * Likes:    1823
 * Dislikes: 0
 * Total Accepted:    715.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 
 * 
 * 
 * 提示： 
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int r = nums.length;
        int l = 0;
        while (l < r) {
            int t = new Random().nextInt(l, r);
            swap(nums, l, t);
            int p = partition(nums, l, r);
            if (p == nums.length - k) {
                return nums[p];
            } else if (p > nums.length - k) {
                r = p;
            } else {
                l = p + 1;
            }
        }
        return nums[l];

    }

    public int partition(int[] nums, int l, int r) {
        int x = nums[l];
        int i = l;
        for (int j = l + 1; j < r; j++) {
            if (nums[j] < x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, i);
        return i;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
// @lc code=end
