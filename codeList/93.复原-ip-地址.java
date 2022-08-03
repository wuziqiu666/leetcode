import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder();
        subAddress(s, 0, result, 0, sBuilder);
        return result; 

    }
    public void subAddress(String s, int len, List<String> result, int site, StringBuilder sBuilder){
           if(site == 4){
               if(len == s.length()){
                   result.add(sBuilder.substring(0, sBuilder.length() - 1).toString());
               }
               return;
           }
            if(s.length() - len > (4 - site) * 3 || s.length() - len < 4 - site){
                return;
            }
           for(int i = 1; i < 4 && len + i <= s.length(); i++){

               int num = Integer.parseInt(s.substring(len,len + i));
                if(num > 255 || String.valueOf(num).length() < i ){
                    return;
                }
                StringBuilder tmpBuilder = new StringBuilder(sBuilder.toString());
                tmpBuilder.append(num).append(".");
                subAddress(s, len + i, result, site + 1, tmpBuilder);
            }
    }
}
// @lc code=end
