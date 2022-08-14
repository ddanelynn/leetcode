class CoinChange(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        
        dp = []
        for i in range (amount + 1):
            dp.append(sys.maxint)
        
        for i in range (len(coins)):
            if coins[i] <= amount:
                dp[coins[i]] = 1
        
        for i in range (amount + 1):
            for j in range (len(coins)):
                if i - coins[j] > 0 and dp[i - coins[j]] != sys.maxint:
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        
        return -1 if dp[amount] == sys.maxint else dp[amount]