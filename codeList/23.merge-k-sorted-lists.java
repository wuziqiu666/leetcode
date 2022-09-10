import leetcodeUtil.ListNode;
import java.util.*;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<Stats> queue = new PriorityQueue<>();
       for(ListNode node :lists){
           if(node != null){
               queue.offer(new Stats(node.val, node));
           }
       }
       ListNode head = new ListNode();
       ListNode node = head;
       while(queue.size() != 0){
           Stats stats = queue.poll();
           node.next = stats.node;
           if(stats.node.next != null){
                queue.offer(new Stats(stats.node.next.val, stats.node.next));
           }
           node = node.next;
       }
       return head.next;
    }
    class Stats implements Comparable<Stats>{
        int val;
        ListNode node;
        @Override
        public int compareTo(Stats o) {
            return val - o.val;
        }
        public Stats(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
        
    }
}

// @lc code=end
