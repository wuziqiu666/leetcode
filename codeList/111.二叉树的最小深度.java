import java.util.Queue;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    class NodeHeight{
        TreeNode treeNode;
        int height;
        public NodeHeight(TreeNode node, int height){
            this.treeNode= node;
            this.height = height;
        }
    }
    public int minDepth(TreeNode root) {
        Queue<NodeHeight> queue = new LinkedList<NodeHeight>();
        NodeHeight node = new NodeHeight(root, 1);
        queue.offer(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            if(node.treeNode == null){
                return node.height - 1;
            }
            if(node.treeNode.left == null && node.treeNode.right == null){
                return node.height; 
            } else if(node.treeNode.left == null && node.treeNode.right != null){
                node = new NodeHeight(node.treeNode.right, node.height + 1);
                queue.offer(node);
            } else if(node.treeNode.left != null && node.treeNode.right == null){
                node = new NodeHeight(node.treeNode.left, node.height + 1);
                queue.offer(node);
            } else {
                NodeHeight nodel = new NodeHeight(node.treeNode.left, node.height + 1);
                queue.offer(nodel);
                NodeHeight noder = new NodeHeight(node.treeNode.right, node.height + 1);
                queue.offer(noder);
            }
        }
        return 0;
    }
}
// @lc code=end
