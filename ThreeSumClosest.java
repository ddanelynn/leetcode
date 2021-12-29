import java.util.*;

public class ThreeSumClosest {
  public static int threeSumClosest(int[] nums, int target) {
    int closest = Integer.MAX_VALUE;
    int sum = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {
          if (j == i) {
            continue;
          }
          for (int k = 0; k < nums.length; k++) {
            if (k == i || k == j) {
              continue;
            }
            int tempSum = nums[i] + nums[j] + nums[k];
            int diff = Math.abs(tempSum - target);
            if (diff < closest) {
              closest = diff;
              sum = tempSum;
            }
          }
        }
    } 
    
    return sum;
  }

  public static void main(String args[]) {
    int[] nums = {0, 2, 1, -3};
    System.out.println(threeSumClosest(nums, 1));
  }
}
