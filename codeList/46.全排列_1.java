import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (78.67%)
 * Likes:    2146
 * Dislikes: 0
 * Total Accepted:    684K
 * Total Submissions: 869.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permuteNum = new ArrayList<>();
        dfs(ans, permuteNum, nums);
        return ans;

    }

    public void dfs(List<List<Integer>> ans, List<Integer> permuteNum, int[] nums) {
        if (permuteNum.size() == nums.length) {
            ans.add(new ArrayList<>(permuteNum));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permuteNum.contains(nums[i])) {
                continue;
            }
            permuteNum.add(nums[i]);
            dfs(ans, permuteNum, nums);
            permuteNum.remove(permuteNum.size() - 1);
        }
    }
}
// @lc code=end

