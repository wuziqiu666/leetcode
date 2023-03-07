class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        String[] keys = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; i < keys.length; i++) {
            ans.append(keys[i].repeat(num / values[i]));
            num = num % values[i];
        }
        return ans.toString();

    }
}