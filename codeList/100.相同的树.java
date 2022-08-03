import java.util.Stack;
/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while ((p != null && q != null) || !stack1.isEmpty()) {
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                stack1.push(p);
                stack2.push(q);
                p = p.left;
                q = q.left;
                if ((p == null && q != null) || (p != null && q == null)) {
                    return false;
                }
            }
            p = stack1.pop().right;
            q = stack2.pop().right;
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return true;
    }
}
// @lc code=end
