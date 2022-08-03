/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode P = root.left;
        TreeNode Q = root.right;
        return nodeSame(P, Q);
    }

    public boolean nodeSame(TreeNode P, TreeNode Q) {
        if (P == null && Q == null) {
            return true;
        } else if ((P != null && Q == null) || (P == null && Q != null)) {
            return false;
        }
        if (P.val != Q.val) {
            return false;
        }
        return nodeSame(P.left, Q.right) && nodeSame(P.right, Q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
// @lc code=end
