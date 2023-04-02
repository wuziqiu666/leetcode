class Solution {
    int[] next;
    public int strStr(String haystack, String needle) {
        preprocess(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if(j == needle.length()){
                return i - j + 1;
            }
        }
        return -1;
        
    }

    void preprocess(String needle) {
       next = new int[needle.length()]; 
       next[0] = 0;
       int j = 0;
       for(int i = 1; i < needle.length(); i++) {
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
       }

    }
}