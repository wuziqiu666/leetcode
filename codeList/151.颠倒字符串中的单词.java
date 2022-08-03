/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] sList = s.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for(int i = sList.length - 1; i >= 0; i--){
            if(!"".equals(sList[i])){
                sBuilder.append(sList[i]).append(" ");
            }
        }
        return sBuilder.substring(0, sBuilder.length() - 1).toString();
    }
}
// @lc code=end

