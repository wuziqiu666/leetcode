import java.util.ArrayList;
import java.util.List;

import leetcodeUtil.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.49%)
 * Likes:    1364
 * Dislikes: 0
 * Total Accepted:    324.9K
 * Total Submissions: 585.3K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre;
        ListNode node = new ListNode();
        ListNode preHead = node;
        node.next = head;
        int site = 0;
        while(site < left - 1){
            node = node.next;
            site++;
        }
        pre = node;
        node = node.next;
        while (site < right - 1) {
            ListNode tmp = node;
            move(pre, tmp);
            site++;
        }
        return preHead.next;

    }

    public void move(ListNode pre, ListNode preNode) {
        ListNode tmp = preNode.next;
        preNode.next = preNode.next.next;
        tmp.next = pre.next;
        pre.next = tmp;
    }
}
// @lc code=end

