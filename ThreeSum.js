var threeSum = function(nums) {
    nums.sort((a, b) => a - b);
    const result = [];
    for (var i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        var left = i + 1;
        var right = nums.length - 1;

        while (left < right) {
            const threeSum = nums[i] + nums[left] + nums[right];
            if (threeSum > 0) {
                right--;
            } else if (threeSum < 0) {
                left++;
            } else {
                result.push([nums[i], nums[left], nums[right]]);
                left++;
                while (nums[left] === nums[left - 1] && left < right) {
                    left++;
                }
            }
        }
    } 
    return result;
};