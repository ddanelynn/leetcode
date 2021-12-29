var maxSubArray = function(nums) {
    var currSum = 0;
    var currMax = nums[0];
    for (var i = 0; i < nums.length; i++) {
        if (currSum < 0) {
            currSum = 0;
        } 
        currSum += nums[i];
        currMax = Math.max(currMax, currSum);
    }
    return currMax;
};

console.log(maxSubArray([-2, -3, -5, -1]));