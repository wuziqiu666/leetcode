import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.56%)
 * Likes:    1212
 * Dislikes: 0
 * Total Accepted:    363K
 * Total Submissions: 537.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ansMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String mapStr = new String(chars);
            List<String> list = ansMap.getOrDefault(mapStr, new ArrayList<>());
            list.add(str);
            ansMap.put(mapStr, list);
        }
        for (List<String> list : ansMap.values()) {
            ans.add(list);
        }
        return ans;

    }
}
// @lc code=end

