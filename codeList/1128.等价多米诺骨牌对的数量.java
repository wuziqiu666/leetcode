
/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 *
 * https://leetcode.cn/problems/number-of-equivalent-domino-pairs/description/
 *
 * algorithms
 * Easy (54.30%)
 * Likes:    140
 * Dislikes: 0
 * Total Accepted:    39.7K
 * Total Submissions: 73.2K
 * Testcase Example:  '[[1,2],[2,1],[3,4],[5,6]]'
 *
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且
 * b==c。
 * 
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对
 * (i, j) 的数量。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] sum = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] > domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += sum[val];
            sum[val] += 1;
        }
        return ret;
    }
}
// @lc code=end
