/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                int p = i + j - 1;
                if(i > 0){
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if(j > 0){
                    f[j] = f[j] || f[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return f[n];
    }

}
// @lc code=end

