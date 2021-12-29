import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                
                if (threeSum < 0) {
                    left++;
                } else if (threeSum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    result.add(arr);
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }
        
        return result;
    }
}
