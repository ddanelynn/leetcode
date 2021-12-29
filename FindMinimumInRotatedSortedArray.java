public class FindMinimumInRotatedSortedArray {
    // public int findMin(int[] nums) {
    //     int start = 0;
    //     int end = nums.length - 1;
        
    //     if (nums.length <= 1) {
    //         return nums[0];
    //     }
        
    //     if (nums[start] < nums[end]) {
    //         return nums[start];
    //     }
        
    //     while (start < end) {
    //         start ++;
    //         end --;
    //         if (nums[start] < nums[start - 1]) {
    //             return nums[start];
    //         }
    //         if (nums[end] > nums[end + 1]) {
    //             return nums[end + 1];
    //         }
    //     }
        
    //     return 0;
    // }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        if (nums.length <= 1) {
            return nums[0];
        }
        
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        
        while (start < end) {
            if (start + 1 == end) {
                return Math.min(nums[start], nums[end]);
            }
            int middle = (start + end)/2;
            if (nums[start] < nums[end]) {
                return nums[start];
            } else {
                if (nums[start] > nums[middle]) {
                    end = middle;
                } else {
                    start = middle;
                } 
            }
        }
        
        return 0;
    }
}
