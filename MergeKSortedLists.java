import java.util.*;

public class MergeKSortedLists {
  public static ListNode mergeKLists(ListNode[] lists) {
      // ListNode result = new ListNode(Integer.MAX_VALUE);
      // if (lists.length == 0) {
      //   return null;
      // }
      // HashMap<Integer, Integer> hm = new HashMap<>();
      // for (ListNode eachList: lists) {
      //   while (eachList != null) {
      //     if (hm.containsKey(eachList.val)) {
      //       hm.put(eachList.val, hm.get(eachList.val) + 1);
      //     } else {
      //       hm.put(eachList.val, 1);
      //     }
      //     eachList = eachList.next;
      //   }
      // }

      // ListNode curr = new ListNode(Integer.MAX_VALUE);
      // for (int i = -10000; i <= 10000; i++) {
      //   if (hm.containsKey(i)) {
      //     for (int j = 0; j < hm.get(i); j++) {
      //       if (result.val == Integer.MAX_VALUE) {
      //         curr.val = i;
      //         result = curr;
      //       } else {
      //         curr.next = new ListNode(i);
      //         curr = curr.next;
      //       }
      //     }
      //   }
      // }

      // if (curr.val == Integer.MAX_VALUE) {
      //   return null;
      // }

      // return result;

      if (lists == null) {
        return null;
      }
      PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
        
      for (ListNode eachList: lists) {
        if (eachList != null) {
          pq.add(eachList);
        }
      }

      ListNode newHead = pq.poll();

      if (newHead != null && newHead.next != null) {
        pq.add(newHead.next);
      }

      ListNode curr = newHead;
      while (!pq.isEmpty()) {
        ListNode min = pq.poll();
        curr.next = min;
        if (min.next != null) {
          pq.add(min.next);
        }
        curr = curr.next;
        
      }

      return newHead;
  }

  static class NodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode node1, ListNode node2) {
      return node1.val - node2.val;
    }
  }

  public static void main(String[] args) {
    ListNode l = new ListNode(1);
    ListNode[] lists = new ListNode[1];
    lists[0] = l;
    mergeKLists(lists); 
  }

  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
}
