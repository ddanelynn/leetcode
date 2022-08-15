import java.util.Arrays;

// 6, 7, 9, 8, 6
// sort
// 6, 6, 7, 8, 9
// add diff
// 9, 9, 10, 11, 9     +3
// rearrange
// 9, 9, 9, 10, 11

// 11, 11, 11, 11, 12
// 12, 12, 12, 12, 12

public class NumberAddition {
    public static int countAddtion(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (nums[nums.length - 1] > nums[0]) {
            int diff = nums[nums.length - 1] - nums[0];
            count += diff;
            int temp = nums[nums.length - 1];
            int[] newArr = new int[nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                newArr[i] = nums[i] + diff;
            }
            for (int i = 1; i < nums.length; i++) {
                nums[i] = newArr[i - 1];
            }
            nums[0] = temp;
            // for (int i = 0; i < nums.length; i++) {
            // System.out.print(nums[i] + " ");

            // }
            // System.out.println();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAddtion(new int[] { 5, 6, 8, 8, 5 }));
    }
}
