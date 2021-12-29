import java.util.*;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < arr.size(); i++) {
            if (i != arr.size() - n) {
                curr.next = new ListNode(arr.get(i));
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
