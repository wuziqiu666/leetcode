import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 *
 * https://leetcode.cn/problems/water-and-jug-problem/description/
 *
 * algorithms
 * Medium (38.61%)
 * Likes:    390
 * Dislikes: 0
 * Total Accepted:    42.6K
 * Total Submissions: 110.1K
 * Testcase Example:  '3\n5\n4'
 *
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到
 * targetCapacity 升。
 * 
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * 
 * 你可以：
 * 
 * 
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 
 * 
 * 
 * 
 * 示例 1: 
 * 
 * 
 * 输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * 输出: true
 * 解释：来自著名的 "Die Hard"
 * 
 * 示例 2:
 * 
 * 
 * 输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * 输出: true
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<Long> seen = new HashSet<>();

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        return getWater(0, jug1Capacity, 0, jug2Capacity, targetCapacity);

    }

    public boolean getWater(int jug1, int jug1Capacity, int jug2, int jug2Capacity, int targetCapacity) {
        if (jug1 == targetCapacity || jug2 == targetCapacity || jug1 + jug2 == targetCapacity) {
            return true;
        }
        if (seen.contains(hash(jug1, jug2))) {
            return false;
        }
        seen.add(hash(jug1, jug2));
        boolean ans = false;
        ans = ans || getWater(0, jug1Capacity, jug2, jug2Capacity, targetCapacity);
        ans = ans || getWater(jug1, jug1Capacity, 0, jug2Capacity, targetCapacity);
        ans = ans || getWater(jug1 + Math.min(jug2, jug1Capacity - jug1), jug1Capacity,
                jug2 - Math.min(jug2, jug1Capacity - jug1), jug2Capacity, targetCapacity);
        ans = ans || getWater(jug1 - Math.min(jug1, jug2Capacity - jug2), jug1Capacity,
                jug2 + Math.min(jug1, jug2Capacity - jug2), jug2Capacity, targetCapacity);
        ans = ans || getWater(jug1Capacity, jug1Capacity, jug2, jug2Capacity, targetCapacity);
        ans = ans || getWater(jug1, jug1Capacity, jug2Capacity, jug2Capacity, targetCapacity);

        return ans;
    }

    public long hash(int a, int b) {
        return ((long) a << 31) + (long) b;
    }
}
// @lc code=end
