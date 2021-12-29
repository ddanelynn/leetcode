import java.util.*;

public class ClimbingStairs {

    // optimal solution
    public static int climbStairs(int n) {
        if (n < 3) {
          return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n + 1; i++) {
          arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    // public static int climbStairs(int n) {
    //     Hashtable<Integer, Integer> ht = new Hashtable<>();
    //     return helper(n, ht);
    // }

    // public static int helper(int n, Hashtable<Integer, Integer> ht) {
    //   if (n == 1) {
    //     ht.put(1, 1);
    //     return 1;
    //   } else if (n == 2) {
    //       ht.put(2, 2);
    //       return 2;
    //   } else {
    //       if (!ht.containsKey(n - 1)) {
    //         ht.put(n - 1, helper(n - 1, ht));
    //       }
    //       if (!ht.containsKey(n - 2)) {
    //         ht.put(n - 2, helper(n - 2, ht));
    //       }
    //       return (ht.get(n - 1) + ht.get(n - 2));
    //   }
    // }
    public static void main(String args[]) {
      System.out.println(climbStairs(45));
    }
}
