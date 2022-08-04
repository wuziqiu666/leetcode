/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode.cn/problems/jump-game/description/
 *
 * algorithms
 * Medium (43.63%)
 * Likes:    1942
 * Dislikes: 0
 * Total Accepted:    554.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个下标。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

/*
 * 每走一步，有两种选择：
 * 1. 保存过去的体力
 * 2. 取新的体力
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int energy = 0;
        for (int i = 0; i < nums.length; i++, energy--) {
            if (energy < 0) {
                return false;
            }
            energy = Math.max(nums[i], energy);
        }
        return true;
    }
}
// @lc code=end

