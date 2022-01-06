package leetcode.solution;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode left = list1;
        ListNode right = list2;
        ListNode res = null;

        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val <= right.val) {
            res = new ListNode(left.val);
            left = left.next;
        } else {
            res = new ListNode(right.val);
            right = right.next;
        }
        ListNode firstNode = res;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                res.next = new ListNode(left.val);
                res = res.next;
                left = left.next;
            } else {
                res.next = new ListNode(right.val);
                res = res.next;
                right = right.next;
            }
        }
        while (left != null) {
            res.next = new ListNode(left.val);
            res = res.next;
            left = left.next;
        }
        while (right != null) {
            res.next = new ListNode(right.val);
            res = res.next;
            right = right.next;
        }
        return firstNode;
    }
}
