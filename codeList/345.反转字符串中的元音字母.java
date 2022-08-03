import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowel = new HashSet<>(); 
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        ArrayList<Integer> vowelSite = new ArrayList<>();
        char[] cList = s.toCharArray();
        for(int i = 0; i < cList.length; i++){
            if(vowel.contains(cList[i])){
                vowelSite.add(i);
            }
        }
        ArrayList<Integer> reverseList = new ArrayList<>(vowelSite);
        Collections.reverse(reverseList);
        for(int i = 0; i < vowelSite.size()/2; i++){
            exchangeChar(cList, vowelSite.get(i), reverseList.get(i));
        }

        return new String(cList);

    }

    public void exchangeChar(char[] cList, int i, int j){
        char tmp = cList[i];
        cList[i] = cList[j];
        cList[j] = tmp;
    }
}
// @lc code=end

