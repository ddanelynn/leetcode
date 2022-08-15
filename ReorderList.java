public class ReorderList {
    // public static void reorderList(ListNode head) {
    // ListNode curr = head;
    // ArrayList<ListNode> pointerArr = new ArrayList<>();

    // while (curr != null) {
    // pointerArr.add(curr);
    // curr = curr.next;
    // }

    // int arrSize = pointerArr.size();

    // ListNode curr2 = head;
    // int frontIndex = 1;
    // int tailIndex = arrSize - 1;
    // for (int i = 0; i < arrSize - 1; i++) {
    // if (i%2 == 0) {
    // curr2.next = pointerArr.get(tailIndex);
    // tailIndex --;
    // } else {
    // curr2.next = pointerArr.get(frontIndex);
    // frontIndex ++;
    // }
    // curr2 = curr2.next;
    // }

    // curr2.next = null;
    // }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode prev = slow.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode curr2 = head;
        ListNode curr3 = prev;
        while (curr3 != null) {
            ListNode temp1 = curr2.next;
            ListNode temp2 = curr3.next;
            curr2.next = curr3;
            curr3.next = temp1;
            curr2 = temp1;
            curr3 = temp2;
        }

        // 1 -> 2 -> 3 4 <- 5 <- 6
        // curr2 curr
        // 1 -> 6 -> 5 -> 4
    } // 1 -> 6 -> 2 -> 3
      // curr2

    public static void main(String args[]) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;

        reorderList(first);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
