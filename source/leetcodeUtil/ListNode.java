package leetcodeUtil;

public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] nums) {
        this.val = nums[0];
        ListNode node = this;
        for(int i = 1; i < nums.length; i++){
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('[');
        while (node != null) {
            sBuilder.append(node.val);
            sBuilder.append(',');
            node = node.next;
        }
        sBuilder.replace(sBuilder.length() - 1, sBuilder.length(), "]");
        return sBuilder.toString();
    }
}
