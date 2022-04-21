import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import leetcodeUtil.TreeNode;

/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode root) {
        Stack<TreeNode> stack= new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        StringBuilder sBuilder = new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(set.contains(node)){
                sBuilder.append(")");
                stack.pop();
                continue;
            }
            set.add(node);
            sBuilder.append("(").append(node.val);
            if(node.left != null && node.right != null){
                stack.push(node.right);
                stack.push(node.left);
            } else if(node.left != null && node.right == null){
                stack.push(node.left);
            } else if(node.left == null && node.right != null){
                sBuilder.append("()");
                stack.push(node.right);
            }
        }
        return sBuilder.substring(1, sBuilder.length() - 1).toString();
    }
}
// @lc code=end

