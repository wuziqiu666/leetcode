package codeList;
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.72%)
 * Likes:    2237
 * Dislikes: 0
 * Total Accepted:    591.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始
 * 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * 
 * 
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(
            solution.search(nums, target)
        );

    }
}

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return get_index(nums, target, l, r);

    }

    public int get_index(int[] nums, int target, int l, int r) {
        if (l > r){
            return -1;
        }
        if (l == r && nums[l] != target) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[l] > target) {
            if (nums[l] < nums[r]) {
                return -1;
            } else {
                if (nums[mid] > target) {
                    if (nums[mid] >= nums[l]) {
                        return get_index(nums, target, mid + 1, r);
                    }else{
                        return get_index(nums, target, l, mid - 1);
                    }
                } else {
                    return get_index(nums, target, mid + 1, r);
                }
            }
        } else {
            if (nums[l] < nums[r]) {
                if (nums[mid] > target) {
                    return get_index(nums, target, l, mid - 1);
                } else {
                    return get_index(nums, target, mid + 1, r);
                }
            } else {
                if (nums[mid] >= target) {
                    return get_index(nums, target, l, mid - 1);
                } else {
                    if (nums[mid] > nums[l]) {
                        return get_index(nums, target, mid + 1, r);
                    } else {
                        return get_index(nums, target, l, mid - 1);
                    }
                }
            }
        }
        
    }
}
// @lc code=end

