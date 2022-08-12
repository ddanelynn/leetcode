class FindMinimumInRotatedSortedArray(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return min(nums[0], nums[1])
        
        left = 0
        right = len(nums) - 1
        if nums[left] < nums[right]:
            return nums[left]
        
        result = nums[0]
        while left < right:
            if nums[left] < nums[right]:
                return min(nums[left], result)
            result = min(nums[right], result)
            mid = int(math.floor(right + left)/2)
            result = min(nums[mid], result)
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid - 1
        
        return result