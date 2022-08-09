import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import leetcodeUtil.ListNode;
import leetcodeUtil.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (72.50%)
 * Likes:    1278
 * Dislikes: 0
 * Total Accepted:    142.2K
 * Total Submissions: 196.1K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(0, n);

    }
    
    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if (l == r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i < r; i++) {
            List<TreeNode> leftList = generateTrees(l, i);
            List<TreeNode> rightList = generateTrees(i + 1, r);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode node = new TreeNode(i + 1);
                    node.left = leftNode;
                    node.right = rightNode;
                    ans.add(node);
                }
            }

        }
        return ans;
        
    }
}
// @lc code=end

