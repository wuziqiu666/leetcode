
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import leetcodeUtil.ListNode;
import leetcodeUtil.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        solution.wordBreak("applepenapple", wordDict);

    }
}
