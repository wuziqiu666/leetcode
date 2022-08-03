import java.util.Random;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (66.70%)
 * Likes:    1420
 * Dislikes: 0
 * Total Accepted:    511.8K
 * Total Submissions: 767.2K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,2,3]
 * 输出：3
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 
 */

// @lc code=start
class Solution {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count = candidate == nums[i] ? count + 1 : count - 1;
        }
        return candidate;
    }

}
// @lc code=end

