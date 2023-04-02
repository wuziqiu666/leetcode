class Solution {
    public int removeElement(int[] nums, int val) {
        int nowsite = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nowsite] = nums[i];
                nowsite++;
            }
        }
        return nowsite;
        
    }
}