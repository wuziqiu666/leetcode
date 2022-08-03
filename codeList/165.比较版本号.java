/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1List = version1.split("\\.");
        String[] v2List = version2.split("\\.");
        for(int i = 0, j = 0; i < v1List.length || j < v2List.length; i++, j++){
           int num1 = i < v1List.length ? Integer.parseInt(v1List[i]) : 0;
           int num2 = j < v2List.length ? Integer.parseInt(v2List[j]) : 0;
           if(num1 != num2){
                return num1 > num2 ? 1 : -1;
           }
        }
        return 0;
    }
}
// @lc code=end

