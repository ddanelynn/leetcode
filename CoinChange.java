import java.util.Arrays;
import java.util.Hashtable;

public class CoinChange {
  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    for (int coin : coins) {
      if (coin <= amount) dp[coin] = 1;
    } 

    for (int i = 1; i < amount + 1; i++) {
      for (int coin: coins) {
        if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }

    return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
  }

  public static void main (String args[]) {
    int[] coins = new int[3];
    coins[0] = 1;
    coins[1] = 2;
    coins[2] = 5;

    System.out.println(coinChange(coins, 11));
  }
}
