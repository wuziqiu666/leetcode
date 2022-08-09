package leetcodeUtil;

import java.util.LinkedList;
import java.util.Queue;


public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int level() {
            if (left == null && right == null) {
                return 1;
            } else {
                int l1 = left != null ? left.level() : 0;
                int l2 = right != null ? right.level() : 0;
                return Math.max(l1, l2) + 1;
            }
        }
        @Override
        public String toString() {
            int level = level();
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append('[');
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (queue.size() != 0 && level > 0) {
                int size = queue.size();
                while (size != 0) {
                    TreeNode node = queue.remove();
                    if (node == null) {
                        sBuilder.append("null");
                        sBuilder.append(',');
                    } else {
                        sBuilder.append(node.val);
                        sBuilder.append(',');
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                    size--;
                }
                level--;
            }
            sBuilder.replace(sBuilder.length() - 1, sBuilder.length(), "]");
            return sBuilder.toString();
        }
}
