/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Medium (61.44%)
 * Likes:    608
 * Dislikes: 0
 * Total Accepted:    92.6K
 * Total Submissions: 150.6K
 * Testcase Example:  '1\n2'
 *
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：a = 1, b = 2
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：a = 2, b = 3
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -1000 <= a, b <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        int carry;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
// @lc code=end

//加法器模拟 
        // int carry = 0;
        // int ret = 0;
        // for (int i = 0; i < 32; i++) {
        //     int k = 1 << i; 
        //     int ia = a & k;
        //     int ib = b & k;
        //     ret = ret | (ia ^ ib ^ carry);  
        //     carry = (ia & ib) | ((ia ^ ib) & carry);
        //     carry = carry << 1;
        // }
        // return ret;
