class MaximumProductSubarray(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        maxPositive = nums[0]
        maxNegative = nums[0]
        maxProd = nums[0]
        for i in range(1, len(nums)):
            temp = max(nums[i], maxPositive * nums[i], maxNegative * nums[i])
            maxNegative = min(nums[i], maxPositive * nums[i], maxNegative * nums[i])
            maxProd = max(maxProd, maxPositive)
            maxPositive = temp
            maxProd = max(maxProd, maxPositive)
                
        return maxProd