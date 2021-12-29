var findMin = function(nums) {
    var start = 0;
    var end = nums.length - 1;
    
    if (nums.length <= 1) {
        return nums[0];
    }

    if (nums[start] < nums[end]) {
        return nums[start];
    }


    while (start < end) {
        start++;
        end--;
        if (nums[start] < nums[start - 1]) {
            return nums[start];
        }

        if (nums[end] > nums[end + 1]) {
            return nums[end + 1];
        }
    }
    return 0;
};