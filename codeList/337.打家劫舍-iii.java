import java.util.HashMap;
import java.util.Map;


import leetcodeUtil.TreeNode;
/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 *
 * https://leetcode.cn/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (60.86%)
 * Likes:    1410
 * Dislikes: 0
 * Total Accepted:    216.6K
 * Total Submissions: 355.6K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果
 * 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7 
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 
 * 示例 2:
 * 
 * 
 * 
 * 
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 树的节点数在 [1, 10^4] 范围内
 * 0 <= Node.val <= 10^4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int noSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] { selected, noSelected };

    }
}
// @lc code=end
