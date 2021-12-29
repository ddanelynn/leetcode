import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] result = twoSum(nums, 6);
        System.out.println("result is [" + result[0] + ", " + result[1] + "]");
     
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                ht.put(nums[i], ht.get(nums[i]) + 1);
            } else {
                ht.put(nums[i], 1);
            }
        }

        System.out.println("the hashtable is " + ht);

        int difference = 0;
        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i];
            //System.out.println("difference is " + difference);
            if (ht.get(nums[i]) == 1) {
                ht.remove(nums[i]);
            } else {
                ht.put(nums[i], ht.get(nums[i]) - 1);
            }
            if (ht.containsKey(target - nums[i])) {
                
                result[0] = i;  
                break; 
            } else {
                if (ht.containsKey(nums[i])) {
                    ht.put(nums[i], ht.get(nums[i]) + 1);
                } else {
                    ht.put(nums[i], 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == difference && i != result[0]) {
                result[1] = i;
            }
        }
        return result;
    }
}