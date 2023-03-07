import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 1; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;    
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(sum - target) == 0){
                    return sum;
                }else{
                    ans = Math.abs(sum - target) > Math.abs(ans - target) ? ans : sum; 
                    if(sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
