/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String numStr = "1";
        StringBuilder desStr = new StringBuilder();
        for(int i = 1; i < n; i++){
            char[] cList = numStr.toCharArray();
            for(int sum = 0, j = 0; j < cList.length; j++){
                sum++;
                if(j == cList.length - 1 || cList[j] != cList[j + 1]){
                    desStr.append(sum).append(cList[j]);
                    sum = 0;
                }
            }
            numStr = desStr.toString();
            desStr = new StringBuilder();
        }
        return numStr;
    }
}
// @lc code=end

