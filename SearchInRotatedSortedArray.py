class SearchInRotatedSortedArray(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
        
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left)//2
            if nums[mid] == target:
                return mid
            if nums[left] == target:
                return left
            if nums[right] == target:
                return right
            if nums[left] < nums[right]:
                if target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:  
                if target > nums[mid]:  # 7, 0, 1, 2, 3, 4, 5, 6; target 4   
                                        # 2, 3, 4, 5, 6, 7, 0, 1; target 7
                    if target > nums[left] and nums[mid] < nums[right]:
                        right = mid - 1
                    else:
                        left = mid + 1
                else:                    # 7, 8, 0, 1, 2, 3, 4, 5, 6; target 8
                    if nums[mid] < nums[right]:     # 7, 0, 1, 2, 3, 4, 5, 6; target 0  
                        right = mid - 1
                    else:                           
                        if target > nums[left]:     # 2, 3, 4, 5, 6, 7, 0, 1; target 0
                            right = mid - 1
                        else:                       # 2, 3, 4, 5, 6, 7, 0, 1; target 3
                            left = mid + 1
        return -1