package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<ListNode> tmp =  new ArrayList<>();
        while(head != null) {
            head = split(head, tmp);
            if (head != null) {
                head = head.next;
            }
        }
        // System.out.println(tmp);

        head = merge(tmp).get(0);
        return head;
    }

    private List<ListNode> merge(List<ListNode> tmp) {
        if (tmp.size() < 2)
            return tmp;
        List<ListNode> res = new ArrayList<>();
        while (tmp.size() > 0) {
            res.add(mergeSort(tmp.size()>0 ? tmp.remove(0):null,
                    tmp.size() >0 ? tmp.remove(0):null));
        }
        return merge(res);
    }

    private ListNode split(ListNode node, List<ListNode> tmp) {
        if (node.next != null) {
            if (node.next.val >= node.val) {
                tmp.add(new ListNode(node.val, new ListNode(node.next.val)));
            } else {
                tmp.add(new ListNode(node.next.val, new ListNode(node.val)));
            }
        } else {
            tmp.add(node);
        }
        return node.next;
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode index = null;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                if (head == null) {
                    head = new ListNode(left.val);
                    index = head;
                } else {
                    index.next = new ListNode(left.val);
                    index = index.next;
                }
                left = left.next;
            } else  {
                if (head == null) {
                    head = new ListNode(right.val);
                    index = head;
                } else {
                    index.next = new ListNode(right.val);
                    index = index.next;
                }
                right = right.next;
            }
        }
        while (left != null) {
            if (head == null) {
                head = new ListNode(left.val);
                index = head;
            } else {
                index.next = new ListNode(left.val);
                index = index.next;
            }
            left = left.next;
        }
        while (right != null) {
            if (head == null) {
                head = new ListNode(right.val);
                index = head;
            } else {
                index.next = new ListNode(right.val);
                index = index.next;
            }
            right = right.next;
        }
        return head;
    }
}
