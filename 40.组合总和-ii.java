import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (60.56%)
 * Likes:    1054
 * Dislikes: 0
 * Total Accepted:    328.6K
 * Total Submissions: 542.7K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 
 * 注意：解集不能包含重复的组合。 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 示例 2:
 * 
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(ans, combination, candidates, target, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combination.add(candidates[i]);
                dfs(ans, combination, candidates, target - candidates[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
// @lc code=end

