import leetcodeUtil.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode node1 = pre;
        ListNode node2;
        while (node1.next != null && node1.next.next != null) {
            node2 = node1.next.next;
            node1.next.next = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node1.next.next;
            
        }
        return pre.next;
    }
}