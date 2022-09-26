public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
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

    // divice and conquer method: O(nlogn)
    public static int[] maxSum(int[] nums, int left, int right) {
        if (left == right) {
            return new int[] { nums[left], left, right };
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = maxSum(nums, left, mid);
        int[] rightResult = maxSum(nums, mid + 1, right);
        int leftMax = leftResult[0];
        int rightMax = rightResult[0];

        if (leftMax > 0 && rightMax > 0) {
            int sum = arrSum(nums, leftResult[1], rightResult[2]);
            if (sum > Math.max(leftMax, rightMax)) {
                return new int[] { sum, leftResult[1], rightResult[2] };
            }
        }

        if (leftMax > rightMax) {
            return new int[] { leftMax, leftResult[1], leftResult[2] };
        } else {
            return new int[] { rightMax, rightResult[1], rightResult[2] };
        }

    }

    public static int arrSum(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -5, 4, 3, -3, -10, -5, 1 };
        System.out.println(maxSum(nums, 0, nums.length - 1)[0]);
        System.out.println(maxSum(nums, 0, nums.length - 1)[0] == maxSubArray(nums));
    }

}
