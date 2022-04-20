/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int a = 0, b = 1, c = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                c += b;
            }
            if(i >= 1){
            int num= Integer.parseInt(s.substring(i - 1, i + 1));
                if(num>= 10 && num<= 26){
                    c+=a;
                }
            }
            a = b;
            b = c;
            c = 0;
        }
        return b;
    }
}
// @lc code=end

// 2  2  6
// 1  1  2
// 0  1  1