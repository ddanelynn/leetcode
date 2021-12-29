var containsDuplicate = function(nums) {
    const mySet = new Set();
    for (const num of nums) {
        if (mySet.has(num)) {
            return true;
        } else {
            mySet.add(num);
        }
    }
    return false;
};