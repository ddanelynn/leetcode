var productExceptSelf = function(nums) {
    const leftProduct = new Array(nums.length);
    const rightProduct = new Array(nums.length);
    
    leftProduct[0] = nums[0];
    rightProduct[nums.length - 1] = nums[nums.length - 1];
    
    for (var i = 1; i < nums.length; i++) {
        leftProduct[i] = leftProduct[i - 1] * nums[i];
    }
    
     for (var i = nums.length - 2; i >= 0; i--) {
        rightProduct[i] = rightProduct[i + 1] * nums[i];
    }

    const result = new Array(nums.length);
    result[0] = rightProduct[1];
    
    for (var i = 1; i < nums.length - 1; i++) {
        result[i] = leftProduct[i - 1] * rightProduct[i + 1];
    }

    result[nums.length - 1] = leftProduct[nums.length - 2];
    
    return result;
};