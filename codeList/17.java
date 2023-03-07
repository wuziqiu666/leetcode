import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        Queue<String> combinations = new LinkedList<>();
        String[] keyBoardMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        for(char c : keyBoardMap[digits.charAt(0) - '2'].toCharArray()){
            combinations.add(String.valueOf(c));
        }

        for (int i = 1; i < digits.length(); i++) {
            int len = combinations.size();
            for(int j = 0; j < len; j++){
                String tmpCombination = combinations.poll();
                for(char c: keyBoardMap[digits.charAt(i) - '2'].toCharArray()){
                    combinations.add(tmpCombination + c);
                }
            }
        }
        return new ArrayList<>(combinations);

        
    }
}
