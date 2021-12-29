var coinChange = function(coins, amount) {
    if (amount === 0) {
        return 0;
    }

    const dp = new Array(amount + 1);
    dp.fill(Number.MAX_VALUE);

    for (const coin of coins) {
        if (coin <= amount) {
            dp[coin] = 1;
        } 
    }

    for (let i = 1; i < dp.length; i++) {
        for (const coin of coins) {
            if (i - coin > 0 && dp[i - coin] != Number.MAX_VALUE) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
    }

    return dp[amount] === Number.MAX_VALUE ? -1 : dp[amount];
};