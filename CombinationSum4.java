import java.util.Arrays;

public class CombinationSum4 {
  public int combinationSum4(int[] nums, int target) {

    int[] dp = new int[target + 1];

    Arrays.fill(dp, 0);
    dp[0] = 1;

    for (int i = 1; i < target + 1; i++) {
      for (int num : nums) {
        if (i >= num) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];

  }
}
