package leetcode.solution;


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum%10, new ListNode(sum/10));
        loopAdd(head, l1.next, l2.next);
        return head;
    }

    private void loopAdd(ListNode curr, ListNode l1, ListNode l2) {
        if (l1 == null && l2 ==null) {
            if (curr.next.val == 0 && curr.next.next == null)
                curr.next = null;
            return;
        }
        int p = 0;
        int s = 0;
        int sum = 0;

        if (l1 != null && l2 != null) {
            sum = l1.val+l2.val+ curr.next.val;
        } else if (l1 == null && l2 != null) {
            sum = l2.val + curr.next.val;
        } else if (l2 == null && l1 != null) {
            sum = l1.val + curr.next.val;
        }

        p = sum/10;
        s = sum%10;
//        if (p==0 && s== 0) {
//            if (curr.next.val == 0 && curr.next.next == null)
//                curr.next = null;
//            return;
//        }
        curr.next = new ListNode(s, new ListNode(p));
        loopAdd(curr.next, l1 == null ? null: l1.next , l2 == null ? null: l2.next);
    }

}
