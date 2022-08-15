package leetcodeUtil;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 层序遍历，需要把每层的null写出来才能识别
     * @param s 层序遍历val数组
     */
    public TreeNode(String s) {
        s = s.substring(1, s.length() - 1);
        String[] valStrings = s.split(",");
        if(valStrings.length == 0 || "null".equals(valStrings[0].strip())){
            return;
        } 
        this.val = Integer.valueOf(valStrings[0].strip());
        TreeNode[] nodes = new TreeNode[valStrings.length];
        nodes[0] = this;
        for (int i = 1; i < valStrings.length; i++) {
            if ("null".equals(valStrings[i].strip())) {
                continue;
            }
            nodes[i] = new TreeNode(Integer.valueOf(valStrings[i].strip()));
        }
        for(int i = 1; i <= valStrings.length; i++){
            if (nodes[i - 1] == null) {
                continue;
            }
            if (i * 2 <= valStrings.length) {
                nodes[i - 1].left = nodes[i * 2 - 1];
            }
            if (i * 2 + 1 <= valStrings.length) {
                nodes[i - 1].right = nodes[i * 2];
            }
        }
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
