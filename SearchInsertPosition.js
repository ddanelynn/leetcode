/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    let start = 0;
    let end = nums.length - 1;

    while(start <= end) {
        let mid = start + Math.floor((end - start)/2);
        if (nums[mid] === target) {
            return mid;
        }

        if (target > nums[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return start;
};

const nums = [1, 3, 5, 6];
console.log(searchInsert(nums, 5));