import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 *
 * https://leetcode.cn/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (29.10%)
 * Likes:    645
 * Dislikes: 0
 * Total Accepted:    84.9K
 * Total Submissions: 291.4K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j])
 * ，同时又满足 abs(i - j)  。
 * 
 * 如果存在则返回 true，不存在返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -2^31 
 * 0 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int w = t + 1;
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }

            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }
            map.put(id, (long)nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;

    }

    /**
     * 分桶 -t - 1 ... -1/0...t/t + 1...2t + 1
     * 
     * @param value
     * @param w
     * @return
     */
    public long getId(long value, long w) {
        if (value >= 0) {
            return value / w;
        }
        return (value + 1) / w - 1;
    }
}
// @lc code=end
