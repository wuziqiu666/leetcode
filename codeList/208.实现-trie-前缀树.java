import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (71.97%)
 * Likes:    1262
 * Dislikes: 0
 * Total Accepted:    220.5K
 * Total Submissions: 306.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Trie（发音类似 "try"）或者说 前缀树
 * 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 
 * 请你实现 Trie 类：
 * 
 * 
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回
 * false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true
 * ；否则，返回 false 。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
 * 
 * 
 */

// @lc code=start
class Trie {

    Node pre;

    public Trie() {
        pre = new Node(' ', false);
    }

    public void insert(String word) {
        pre.insert(word.toCharArray(), 0, word.length());

    }

    public boolean search(String word) {
        return pre.search(word);
    }

    public boolean startsWith(String prefix) {
        return pre.startWith(prefix);

    }

    class Node {
        Node[] subNodes;
        char letter;
        boolean isWord;

        Node(char letter, boolean isWord) {
            subNodes = new Node[26];
            this.letter = letter;
            this.isWord = isWord;
        }

        void insert(char[] letters, int left, int right) {
            if (left == right) {
                this.isWord = true;
                return;
            }
            char tmp = letters[left];
            int site = tmp - 'a';
            if (subNodes[site]  != null) {
                subNodes[site].insert(letters, left + 1, right);
            } else {
                Node node = new Node(tmp, false);
                subNodes[site] = node;
                node.insert(letters, left + 1, right);
            }
        }

        boolean search(String word) {
            Node node = searchPrefix(word.toCharArray(), 0, word.length());
            return node != null && node.isWord;
        }

        boolean startWith(String word) {
            return searchPrefix(word.toCharArray(), 0, word.length()) != null;
            
        }

        Node searchPrefix(char[] letters, int left, int right) {
            char tmp = letters[left];
            int site = tmp - 'a';
            if (subNodes[site] != null) {
                if (left + 1 == right) {
                    return subNodes[site];
                }
                return subNodes[site].searchPrefix(letters, left + 1, right);
            } else {
                return null;
            }

        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
