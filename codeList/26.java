
class Solution {
    public int removeDuplicates(int[] nums) {
        int nowSite = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[nowSite]) {
                nowSite++;
                nums[nowSite] = nums[i];
            }
        }
        return nowSite + 1;
    }
}