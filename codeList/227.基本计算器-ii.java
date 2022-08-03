import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preSign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                switch(preSign){
                    case '+':stack.push(num);
                    break;
                    case '-':stack.push(-num);
                    break;
                    case '*':stack.push(stack.pop() * num);
                    break;
                    case '/':stack.push(stack.pop() / num);
                    break;
                } 
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        } 
        return ans;
    }
}
// @lc code=end

