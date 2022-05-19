public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] <= nums[right]) {
                    right = mid - 1;
                }
            } else if (nums[mid] <= target) {
                if (nums[right] >= nums[mid]) {
                    if (nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
