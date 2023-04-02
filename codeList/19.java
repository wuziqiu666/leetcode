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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode n1 = pre, n2 = pre;
        for (int i = 0; i < n; i++) {
            n2 = n2.next;
        }
        while (n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n1.next = n1.next.next;
        return pre.next;
        
    }
}