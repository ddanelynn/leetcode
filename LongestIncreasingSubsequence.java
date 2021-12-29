import java.util.*;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);
     int finalMax = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
        for (int j = i; j < nums.length; j++) {
          if (nums[j] > nums[i]) {
            dp[i] = Math.max(dp[j] + 1, dp[i]);
            finalMax = Math.max(finalMax, dp[i]);
          }
        }
      }
      return finalMax;
  }
}
