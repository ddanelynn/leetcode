var maxProduct = function(nums) {
    let maxProduct = nums[0]
    let maxCurrProduct = nums[0]
    let minCurrProduct = nums[0]
    for(let i=1;i<nums.length;i++){
        let temp = Math.max(nums[i],maxCurrProduct*nums[i],minCurrProduct*nums[i])
        minCurrProduct = Math.min(nums[i],maxCurrProduct*nums[i],minCurrProduct*nums[i])
        maxProduct = Math.max(maxProduct,maxCurrProduct)
        maxCurrProduct = temp
        maxProduct = Math.max(maxCurrProduct,maxProduct)
    }
    return maxProduct
};