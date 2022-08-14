class LongestIncreasingSubsequence(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        dp = []
        for i in range(len(nums)):
            dp.append(1)
        maxLength = 1
        
        for i in reversed(range(len(nums))):
            for j in range (i + 1, len(nums)):
                if nums[i] < nums[j]:
                    dp[i] = max(dp[j] + 1, dp[i])
                    maxLength = max(dp[i], maxLength)
                
        return maxLength
                