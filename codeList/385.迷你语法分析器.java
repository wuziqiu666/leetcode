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
 */
class Solution {
    int index = 0;
    public NestedInteger deserialize(String s) {
        if(s.charAt(index) == '['){
            index++;
            NestedInteger node = new NestedInteger();
            while(s.charAt(index) != ']'){
                node.add(deserialize(s));
                if(s.charAt(index) == ','){
                    index++;
                }
            }
            index++;
            return node;
        } else {
            boolean flag = false;
            int num = 0;
            if(s.charAt(index) == '-'){
                flag = true;
                index++;
            }
            while(index < s.length() && Character.isDigit(s.charAt(index))){
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            num = flag ? -num : num;
            return new NestedInteger(num);            
        }
    }
}
// @lc code=end
// 遇到[，则将上一个NestedInteger放入栈，使用新的NestedInteger
// 遇到]，则将栈中的NestedInteger取出来，add对应的NestedInteger，重新放入栈中
// 遇到数字，add 对应的NestedInteger 
