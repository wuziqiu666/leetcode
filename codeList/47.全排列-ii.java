import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode.cn/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (65.01%)
 * Likes:    1150
 * Dislikes: 0
 * Total Accepted:    355.5K
 * Total Submissions: 546.7K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
		List<Integer> permuteNum = new ArrayList<>();
        dfs(ans, permuteNum, nums, used);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> permuteNum, int[] nums, boolean[] used) {
        if (permuteNum.size() == nums.length) {
            ans.add(new ArrayList<>(permuteNum));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (!used[i]) {
                permuteNum.add(nums[i]);
                used[i] = true;
                dfs(ans, permuteNum, nums, used);
                used[i] = false;
                permuteNum.remove(permuteNum.size() - 1);
            }
        }
            
    }
}
// @lc code=end

