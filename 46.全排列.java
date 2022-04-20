import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            output.add(nums[i]);
        }
        backtrack(result, output, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> output, int site) {
        if (site == output.size() - 1) {
            result.add(new ArrayList<>(output));
        }
        for (int i = site; i < output.size(); i++) {
            swap(output, site, i);
            backtrack(result, output, site + 1);
            swap(output, site, i);
        }

    }

    public void swap(List<Integer> output, int i, int j) {
        int tmp = output.get(i);
        output.set(i, output.get(j));
        output.set(j, tmp);
    }
}
// @lc code=end
