import java.util.*;

public class NumberOfGoodPairs {
    public static void main (String[] args) {

        int[] nums = new int[] { 1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {

        int numPairs = 0;

        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                ht.put(nums[i], ht.get(nums[i]) + 1);
            } else {
                ht.put(nums[i], 1);
            }
        }

        Collection<Integer> c = ht.values();

        for (int value: c) {
            if (value > 1) {
                numPairs += (value * (value - 1))/2;
            }
        }

        return numPairs;
    }
}
