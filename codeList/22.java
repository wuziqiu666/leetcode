import java.util.*;
class Solution {
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        generate("");
        return ans;
    }

    void generate(String brackets) {
        int leftCount = 0;
        int rightCount = 0;
        for (char bracket : brackets.toCharArray()) {
            if(bracket == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
        }
        if (leftCount < n) {
            generate(brackets + '(');
        }
        if (rightCount < leftCount) {
            generate(brackets + ')');
        }
        if (rightCount == n) {
            ans.add(brackets);
        }

    }
}