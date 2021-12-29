var twoSum = function(nums, target) {
    const numsDict = {};
    const answerArr = [];
    nums.forEach((num, index) => {
        if (numsDict[num] !== undefined) {
            if (num*2 === target) {
                answerArr.push(numsDict[num]);
                answerArr.push(index);
                return answerArr;
            }
        }
        numsDict[num] = index;
    });

    for (var i = 0; i < nums.length; i++) {
        if (numsDict[target - nums[i]] !== undefined && nums[i] * 2 !== target) {
            answerArr.push(numsDict[nums[i]]);
            answerArr.push(numsDict[target - nums[i]]);
            break;
        }
    }
    return answerArr;
};

const nums = [3, 2, 4];
console.log(twoSum(nums, 6));