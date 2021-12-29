var canJump = function(nums) {
    var index = nums.length - 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        if (i + nums[i] >= index) {
            index = i;  
        }
    } 
    return index === 0; 
};