import java.util.Stack;

import leetcodeUtil.NestedInteger;

/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

class Solution {

    public NestedInteger deserialize(String s) {
        if (s.length() == 0) {
            return null;
        }
        if (s.charAt(0) == '-' || Character.isDigit(s.charAt(0))) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        int site = 0;
        while (site < s.length()) {
            if (s.charAt(site) == '[') {
                stack.push(new NestedInteger());
            } else if (s.charAt(site) == ']') {
                NestedInteger nInteger = stack.pop();
                if (stack.size() == 0) {
                    return nInteger;
                } else {
                    stack.peek().add(nInteger);
                }
            } else {
                System.out.println("error");
            }
            int nl = s.indexOf("[", site + 1);
            int nr = s.indexOf("]", site + 1);
            String tmp;
            if (nl == -1 || nr < nl) {
                tmp = s.substring(site + 1, nr);
                site = nr;
            } else {
                tmp = s.substring(site + 1, nl);
                site = nl;
            }
            for (String numString : tmp.split(",")) {
                if (!"".equals(numString)) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(numString)));
                }
            }
        }
        return stack.peek();
    }

}
// @lc code=end
