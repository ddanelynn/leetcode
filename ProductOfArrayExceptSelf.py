class ProductOfArrayExceptSelf(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
            
        leftProduct = []
        rightProduct = []
        result = []
        
        for i in range(len(nums)):
            leftProduct.append(0)
            rightProduct.append(0)
            result.append(0)
        
        leftProduct[0] = nums[0]
        
        for i in range (1, len(nums)):
            leftProduct[i] = nums[i] * leftProduct[i - 1]
        
        rightProduct[len(nums) - 1] = nums[len(nums) - 1] 
        for i in reversed(range(len(nums) - 1)):
            rightProduct[i] = nums[i] * rightProduct[i + 1]
            
        
        result[0] = rightProduct[1]
        for i in range(1, len(nums) - 1):
            result[i] = rightProduct[i + 1] * leftProduct[i - 1]
            
        result[len(nums) - 1] = leftProduct[len(nums) - 2]
        
        return result