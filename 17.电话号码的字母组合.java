import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (57.80%)
 * Likes:    1949
 * Dislikes: 0
 * Total Accepted:    501.9K
 * Total Submissions: 868.2K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Character>> numList;
    List<String> ret;
    public List<String> letterCombinations(String digits) {
        numList = new ArrayList<>();
        numList.add(Arrays.asList('a', 'b', 'c'));
        numList.add(Arrays.asList('d', 'e', 'f'));
        numList.add(Arrays.asList('g', 'h', 'i'));
        numList.add(Arrays.asList('j', 'k', 'l'));
        numList.add(Arrays.asList('m', 'n', 'o'));
        numList.add(Arrays.asList('p', 'q', 'r', 's'));
        numList.add(Arrays.asList('t', 'u', 'v'));
        numList.add(Arrays.asList('w', 'x', 'y', 'z'));
        ret = new ArrayList<>();
        getRet(digits, 0, new StringBuilder());
        return ret;

    }

    void getRet(String digits, int site, StringBuilder sBuilder) {
        if (digits.length() == 0) {
            return;
        }
        if (site == digits.length()) {
            ret.add(sBuilder.toString());
            return;
        }
        for (char c : numList.get(digits.charAt(site) - '2')) {
            sBuilder.append(c);
            getRet(digits, site + 1, sBuilder);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
        return;

    }

}
// @lc code=end

