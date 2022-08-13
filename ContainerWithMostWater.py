class ContainerWithMostWater(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        left = 0
        right = len(height) - 1
        width = len(height) - 1
        maxArea = min(height[left], height[right]) * width
        
        while left < right:
            width-=1
            if height[left] < height[right]:
                left+=1
            else:
                right-=1
            maxArea = max(min(height[left], height[right]) * width, maxArea)
        return maxArea