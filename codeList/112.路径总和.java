import leetcodeUtil.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(targetSum - root.val);

        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int sum = sumQueue.poll();
            if(node == null){
                continue;
            }
            if(node.left == null && node.right == null){
                if(sum == 0){
                    return true;
                } else {
                    continue;
                }
            } else {
                if(node.left != null){
                    nodeQueue.offer(node.left);
                    sumQueue.offer(sum - node.left.val);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                    sumQueue.offer(sum - node.right.val);
                }
            }
        }
        return false; 
    }
}
// @lc code=end

