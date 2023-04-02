class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int site = (left + right) / 2;
            if(target == nums[site]){
                return site;
            }
            if(nums[site] >= nums[left]){
                if(target >= nums[left] && target < nums[site]){
                    right = site - 1;
                }else{
                    left = site + 1;
                }
            }else{
                if(target > nums[site] && target <= nums[right]){
                    left = site + 1;
                }else{
                    right = site - 1;
                }
            }
        }
        return -1;
    }
}
