/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/description/
 *
 * algorithms
 * Medium (50.39%)
 * Likes:    452
 * Dislikes: 0
 * Total Accepted:    63.6K
 * Total Submissions: 126.5K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 
 * 实现词典类 WordDictionary ：
 * 
 * 
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些
 * '.' ，每个 . 都可以表示任何一个字母。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：
 * 
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 10^4 次 addWord 和 search
 * 
 * 
 */

// @lc code=start
class WordDictionary {

    Node pre;

    public WordDictionary() {
        pre = new Node(' ');
    }

    public void addWord(String word) {
        pre.insert(word.toCharArray(), 0, word.length());

    }

    public boolean search(String word) {
        return pre.search(word.toCharArray(), 0, word.length());
    }

    class Node {
        Node[] subNode;
        char letter;
        boolean isWord;

        Node(char letter) {
            subNode = new Node[26];
            this.letter = letter;
            this.isWord = false;
        }

        void insert(char[] letters, int left, int right) {
            if (left == right) {
                this.isWord = true;
                return;
            }
            char tmp = letters[left];
            int site = tmp - 'a';
            if (subNode[site] == null) {
                Node node = new Node(tmp);
                subNode[site] = node;
            }
            subNode[site].insert(letters, left + 1, right);
        }

        boolean search(char[] letters, int left, int right) {
            if (left == right) {
                return isWord;
            }
            char tmp = letters[left];
            boolean ans = false;
            if (tmp == '.') {
                for (Node node : subNode) {
                    if (node != null) {
                        ans = ans || node.search(letters, left + 1, right);
                    }
                }
                return ans;
            }
            int site = tmp - 'a';
            if (subNode[site] != null) {
                ans = subNode[site].search(letters, left + 1, right);
            } else {
                ans = false;
            }
            return ans;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
