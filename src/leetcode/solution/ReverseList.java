package leetcode.solution;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return recursion(new ListNode(head.val), head.next);
    }

    private ListNode recursion(ListNode node, ListNode next) {
        if (next != null) {
            return recursion(new ListNode(next.val, node), next.next);
        }
        return node;
    }
}
