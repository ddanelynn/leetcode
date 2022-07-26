class FindFirstAndLastPositionOfElementInSortedArray:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = [-1, -1]
        ans[0] = self.searchIndex(nums, target, 'l')
        ans[1] = self.searchIndex(nums, target, 'r')
        return ans
                
    def searchIndex(self, nums, target, method):
        first = 0
        last = len(nums) - 1
        index = -1
        
        while (first <= last):
            mid = first + (last - first)//2
            if (nums[mid] == target):
                index = mid
                if method == 'r':
                    first = mid + 1
                else:
                    last = mid - 1
            elif (nums[mid] > target):
                last = mid - 1
            else:
                first = mid + 1

        return index
            
