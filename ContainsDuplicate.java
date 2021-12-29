import java.util.*;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    boolean hasDuplicate = false;
    HashSet<Integer> hs = new HashSet<>();
    for (int num: nums) {
      if (hs.contains(num)) {
        hasDuplicate = true;
        break;
      }
      hs.add(num);
    }
    return hasDuplicate;

    // boolean hasDuplicate = false;
    // Arrays.sort(nums);
    // for (int i = 0; i < nums.length - 1; i++) {
    //     if (nums[i] == nums[i + 1]) {
    //         hasDuplicate = true;
    //         break;
    //     }
    // }
    // return hasDuplicate;
  }
}
