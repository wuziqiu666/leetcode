/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 *
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Medium (27.36%)
 * Likes:    668
 * Dislikes: 0
 * Total Accepted:    84.8K
 * Total Submissions: 309.7K
 * Testcase Example:  '[4,2,3]'
 *
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > y) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;

    }

}
// @lc code=end

