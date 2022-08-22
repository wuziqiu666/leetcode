import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 *
 * https://leetcode.cn/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (53.70%)
 * Likes:    622
 * Dislikes: 0
 * Total Accepted:    85.5K
 * Total Submissions: 159K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = nums[0], count1 = 0;
        int n2 = nums[0], count2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == n1) {
                count1++;
            } else if (nums[i] == n2) {
                count2++;
            } else if (count1 == 0) {
                n1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                n2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == n1) {
                count1++;
            }
            if (nums[i] == n2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            ans.add(n1);
        }
        if (count2 > n / 3 && !ans.contains(n2)) {
            ans.add(n2);
        }

        return ans;
    }
}
// @lc code=end

/**
 * 随机数法
 */
class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < 2 * n; i++) {
            int count = 0;
            int t = new Random().nextInt(0, n);
            t = nums[t];
            if (ans.contains(t)) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (nums[j] == t) {
                    count++;
                }
            }
            if (count > n / 3) {
                ans.add(t);
            }
            if (ans.size() >= 2) {
                break;
            }
        }
        return ans;

    }
}
