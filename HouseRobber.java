public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        rob(nums);
    }
    public static int rob(int[] nums) {
        // if (nums.length == 0) {
        //   return 0;
        // }

        // int maxMoney = 0;
        // int maxRob = 0;
        // int[] dp = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //   dp[i] = nums[i];
        //   maxRob = Math.max(maxRob, nums[i]);
        // }

        // for (int i = 0; i < nums.length; i++) {
        //   for (int j = 0; j < i - 1; j++) {
        //     maxMoney = Math.max(maxMoney, dp[j] + nums[i]);
        //     dp[i] = maxMoney;
        //   }
        // }

        // for (int i : dp) {
        //   System.out.print(i + " ");
        // }

        // return Math.max(maxMoney, maxRob);

        int rob1 = 0;
        int rob2 = 0;
        for (int i = 0; i < nums.length; i++) {
          int temp = Math.max(nums[i] + rob1, rob2);
          rob1 = rob2;
          rob2 = temp;
        }

        return rob2;
    }
}
