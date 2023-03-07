class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minlength = Integer.MAX_VALUE;
        for (String str : strs) {
            minlength = Math.min(minlength, str.length());
        }
        



        for (int i = 0; i < minlength; i++) {
            char temp = strs[0].charAt(i);
            for(String str: strs) {
                if (str.charAt(i) != temp) {
                    return ans.toString();
                }
            }
            ans.append(temp);
        }
        return ans.toString();
    }
}