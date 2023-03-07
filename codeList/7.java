class Solution {
    public int reverse(int x) {
        boolean flag = x > 0;
        x = Math.abs(x);
        int ans = 0;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + digit;
        }
        return flag ? ans : -ans;
        
    }
}