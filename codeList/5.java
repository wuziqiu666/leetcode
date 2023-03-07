
class Solution {
    public String longestPalindrome(String s) {
        String str = "#";
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt(i);
            str += "#";
        }

        int[] p = new int[str.length()];
        int mx = 0, id = 0;

        for (int i = 0; i < str.length(); i++) {
            p[i] = i < mx ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i - p[i] > 0 && i + p[i] < str.length() && str.charAt(i - p[i]) == str.charAt(i + p[i])) {
                p[i]++;
            }
            if(i + p[i] > mx){
                mx = i + p[i];
                id = i;
            }
        }
        
        int maxlen = 0, site = 0;
        for(int i = 0; i < p.length; i++){
            if(p[i] > maxlen){
                maxlen = p[i];
                site = i;
            }
        }
        return str.substring(site - maxlen + 1, site + maxlen).replace("#", "");
    }
}
