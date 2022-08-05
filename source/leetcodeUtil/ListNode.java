package leetcodeUtil;

public class ListNode {
    public int val;
    public ListNode next;
    private ListNode tmp;

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

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('[');
        tmp = this;
        while (tmp != null) {
            sBuilder.append(tmp.val);
            sBuilder.append(',');
            tmp = tmp.next;
        }
        sBuilder.replace(sBuilder.length() - 1, sBuilder.length(), "]");
        return sBuilder.toString();
    }
}
