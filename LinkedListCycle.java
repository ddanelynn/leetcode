import java.util.*;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> s = new HashSet<>();
        while (head != null) {
            if (!s.contains(head)) {
                s.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        
        return false;
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
