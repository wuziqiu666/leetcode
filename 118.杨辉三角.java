import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>(Arrays.asList(1));
        List<Integer> preList= new ArrayList<>(Arrays.asList(1));
        for(int i = 0; i < numRows; i++){
            tmpList = new ArrayList<>();
            tmpList.add(1);
            for(int j = 1; j < i; j++){
                tmpList.add(preList.get(j - 1) + preList.get(j));
            }
            if(i > 0){
                tmpList.add(1);
            }
            res.add(tmpList);
            preList = tmpList;
        }
        return res;
    }
}
// @lc code=end

