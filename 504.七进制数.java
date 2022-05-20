/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (52.15%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    74K
 * Total Submissions: 142K
 * Testcase Example:  '100'
 *
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: num = 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: num = -7
 * 输出: "-10"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -10^7 <= num <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negFlag = num < 0 ? true : false;
        num = Math.abs(num);
        StringBuilder sBuilder = new StringBuilder();
        while (num != 0) {
            sBuilder.append(num % 7);
            num /= 7;
        }
        if (negFlag) {
            sBuilder.append('-');
        }
        return sBuilder.reverse().toString();
    }
}
// @lc code=end

