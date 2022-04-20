import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorStr= new String(charArray);
            List<String> list = map.getOrDefault(sorStr, new ArrayList<>());
            list.add(str);
            map.put(sorStr, list);
        }
        List<List<String>> result = map.values().stream().collect(Collectors.toList());
        return result;
    }
}
// @lc code=end

