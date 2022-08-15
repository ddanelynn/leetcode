def rob(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return max(nums[0], nums[1])
    
    return max(helper(nums[1:]), helper(nums[:-1]))
    
def helper(nums):
    dp = []
    for i in range(len(nums)):
        dp.append(0)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    
    for i in range(2, len(nums)):
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    
    print(dp)
    return dp[len(nums) - 1]

def main():
    rob([200,3,140,20,10])

if __name__ == "__main__":
    main()