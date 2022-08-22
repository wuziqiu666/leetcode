import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 *
 * https://leetcode.cn/problems/rabbits-in-forest/description/
 *
 * algorithms
 * Medium (60.08%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    50.7K
 * Total Submissions: 84.7K
 * Testcase Example:  '[1,1,2]'
 *
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中
 * answers[i] 是第 i 只兔子的回答。
 * 
 * 给你数组 answers ，返回森林中兔子的最少数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：answers = [1,1,2]
 * 输出：5
 * 解释：
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。 
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。 
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。 
 * 因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：answers = [10,10,10]
 * 输出：11
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= answers.length <= 1000
 * 0 <= answers[i] < 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i] + 1, map.getOrDefault(answers[i] + 1, 0) + 1);
        }
        for (int key : map.keySet()) {
            int tmp = key;
            while (map.get(key) > tmp) {
                tmp += key;
            }
            ans += tmp;
        }
        return ans;

    }
}
// @lc code=end

