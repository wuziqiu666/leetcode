import java.util.*;
/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i <= rowIndex; i++){
            list.add(0);
            for(int j = i; j > 0; j--){
                list.set(j, list.get(j) + list.get(j - 1));
            } 
        }
        return list;
    }
}
// @lc code=end

