public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int currSum = 0;

        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += num;
            currMax = Math.max(currMax, currSum);
        }
        return currMax;
    }
}
