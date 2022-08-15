import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcodeUtil.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (65.66%)
 * Likes:    738
 * Dislikes: 0
 * Total Accepted:    231K
 * Total Submissions: 351.7K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: []
 * 输出: []
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100  
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
    public List<Integer> rightSideView(TreeNode root) {
        int level = getLevel(root);
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int t = 0;
        int c = 0;
        while (ans.size() < level)  {
            TreeNode node = stack.pop();
            if (node == null) {
                c++;
                if (c == 2) {
                    t--;
                    c = 0;
                }
                continue;
            }
            if (t == ans.size()) {
                ans.add(node.val);
                t++;
            }
            stack.push(node.left);
            stack.push(node.right);
        }
        return ans;

    }

    public int getLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
    }
}
// @lc code=end

