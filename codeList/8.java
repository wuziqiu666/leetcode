class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int ans = 0;
        boolean flag;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length() || (!Character.isDigit(s.charAt(index)) && s.charAt(index) != '-' && s.charAt(index) != '+')) {
            return 0;
        }

        flag = s.charAt(index) != '-';
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }

        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int cur = s.charAt(index) - '0';
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && -cur < Integer.MIN_VALUE % 10)){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 - cur;
            index++;
        }
        if(ans == Integer.MIN_VALUE && flag){
            return Integer.MAX_VALUE;
        }
        return flag ? -ans : ans;

        
        
    }
}