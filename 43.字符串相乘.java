/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String result = "0";
        for(int i = 0; i < num2.length(); i++){
            StringBuilder sBuilder = new StringBuilder();
            for(int j = i; j > 0; j--){
                sBuilder.append("0");
            }
            int n2 = num2.charAt(num2.length() - 1 - i) - '0';
            int carry = 0;
            for(int j = 0; j < num1.length(); j++){
                int n1 = num1.charAt(num1.length() - 1 - j) - '0'; 
                int res = (n1 * n2 + carry) % 10;
                carry = (n1 * n2 + carry) / 10;
                sBuilder.append(res);
            }
            if(carry != 0){
                sBuilder.append(carry);
            }
            result = add(result, sBuilder.reverse().toString());
        }
        return result;
    }

    public String add(String s1, String s2){
        int i1 = s1.length() - 1, i2 = s2.length() - 1;
        StringBuilder sBuilder = new StringBuilder();
        int carry = 0;
        while(i1 >= 0 || i2 >= 0 || carry != 0){
            int n1 = i1 >= 0 ? s1.charAt(i1) - '0' : 0;
            int n2 = i2 >= 0 ? s2.charAt(i2) - '0' : 0;
            int res = (n1 + n2 + carry) % 10;
            sBuilder.append(res);
            carry = (n1 + n2 + carry) / 10;
            i1--;
            i2--;
        }
        return sBuilder.reverse().toString();
    }
}
// @lc code=end

