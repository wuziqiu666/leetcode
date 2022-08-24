import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (45.84%)
 * Likes:    2103
 * Dislikes: 0
 * Total Accepted:    507.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] count;
    int falseTag;

    public int coinChange(int[] coins, int amount) {
        count = new int[amount + 1];
        falseTag = amount + 1;
        int ans = change(coins, amount);
        return ans >= falseTag ? -1 : ans;

    }

    public int change(int[] coins, int amount) {
        if (amount < 0) {
            return falseTag;
        }
        if (amount == 0) {
            return 0;
        }
        if(count[amount] != 0){
            return count[amount];
        }
        int min = falseTag;
        for (int i : coins) {
            min = Math.min(change(coins, amount - i) + 1, min);
        }
        count[amount] = min;
        return min;

    }
}
// @lc code=end
