import java.util.*;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] nums = new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
    longestConsecutive(nums);
  }

  public static int longestConsecutive(int[] nums) {
    HashSet<Integer> hs = new HashSet<>();
    for (int num : nums) {
      hs.add(num);
    }

    int maxLength = 0;
    for (int num : nums) {
      int currLength = 0;
      if (!hs.contains(num - 1)) {
        currLength++;
        int next = num + 1;
        while (hs.contains(next)) {
          currLength++;
          next++;
        }
        maxLength = Math.max(maxLength, currLength);
      }
    }
    return maxLength;
  }
  // public static int longestConsecutive(int[] nums) {
  // if (nums.length == 0) {
  // return 0;
  // }
  // Arrays.sort(nums);
  // for (int num : nums) {
  // System.out.print(num);
  // }
  // int first = nums[0];
  // int currentMax = 1;
  // int finalMax = 1;
  // for (int i = 1; i < nums.length; i++) {
  // first = nums[i];
  // if (nums[i] == first) {
  // continue;
  // } else if (nums[i] == (first + 1)) {
  // first = nums[i];
  // currentMax++;
  // finalMax = Math.max(finalMax, currentMax);
  // } else {
  // first = nums[i];
  // currentMax = 1;
  // }
  // }
  // return finalMax;
  // }
}
