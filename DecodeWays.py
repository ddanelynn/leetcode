class DecodeWays:
    def numDecodings(self, s: str) -> int:
        dp = []
        for i in range(len(s) + 1):
            dp.append(0)
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1

        for i in range(2, len(s) + 1):
            oneDigit = int(s[i-1 : i])
            twoDigits = int(s[i-2 : i])
            if oneDigit > 0:
                dp[i] += dp[i - 1]
            if twoDigits >= 10 and twoDigits <= 26:
                dp[i] += dp[i - 2]
        
        return dp[len(s)]
        
    