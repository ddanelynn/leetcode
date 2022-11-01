public class BestTimeToBuyAndSellStock {
  public static void main(String args[]) {
    int[] prices = { 2, 11, 1, 4, 7 };
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    int maxProfitValue = 0;
    int currentProfit = 0;
    int start = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < start) {
        start = prices[i];
      } else {
        currentProfit = prices[i] - start;
        if (currentProfit > maxProfitValue) {
          maxProfitValue = currentProfit;
        }
      }
    }
    return maxProfitValue;
  }
}


