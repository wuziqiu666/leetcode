import leetcodeUtil.*;
import java.util.List;


import leetcodeUtil.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        n1.next =l1;
        n2.next = l2;
        while(n1.next != null && n2.next != null){
            int sum = n1.next.val + n2.next.val + carry;
            n1.next.val = sum % 10;
            carry = sum / 10;
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n1.next == null && n2.next != null) {
            n1.next = n2.next;
            while (carry != 0 && n1.next != null) {
                int sum = n1.next.val + carry;
                n1.next.val = sum % 10;
                carry = sum / 10;
                n1 = n1.next;
            }
        } else if (n1.next != null && n2.next == null) {
            while (carry != 0 && n1.next != null) {
                int sum = n1.next.val + carry;
                n1.next.val = sum % 10;
                carry = sum / 10;
                n1 = n1.next;
            }
        }
        if (carry != 0) {
            ListNode node = new ListNode();
            node.val = carry;
            n1.next = node;
        }

        return head;

    }
}
