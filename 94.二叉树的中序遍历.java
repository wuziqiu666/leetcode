import java.util.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTree(root, result);
        return result;
    }

    public void inorderTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTree(root.left, result);
        result.add(root.val);
        inorderTree(root.right, result);
    }
}
// @lc code=end
