class ThreeSum(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        if nums[0] > 0:
            return []
        
        result = []
        for i in range (len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                threeSum = nums[i] + nums[left] + nums[right]
                if threeSum > 0:
                    right-=1
                elif threeSum < 0:
                    left+=1
                else:
                    triplet = [nums[i], nums[left], nums[right]]
                    result.append(triplet)
                    left+=1
                    while nums[left] == nums[left - 1] and left < right:
                        left+=1
                        
        return result