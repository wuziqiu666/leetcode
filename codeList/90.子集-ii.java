import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode.cn/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (63.60%)
 * Likes:    899
 * Dislikes: 0
 * Total Accepted:    229.1K
 * Total Submissions: 360.3K
 * Testcase Example:  '[1,2,2]'
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        dfs(nums, 0, set);
        return ans;

    }

    public void dfs(int[] nums, int site, List<Integer> subSet) {
        ans.add(new ArrayList<>(subSet));
        for (int i = site; i < nums.length; i++) {
            if (i > site && nums[i] == nums[i - 1]) {
                continue;
            }
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet);
            subSet.remove(subSet.size() - 1);
        }
    }
}
// @lc code=end
