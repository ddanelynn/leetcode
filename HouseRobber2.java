import java.util.*;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        int rob3 = 0;
        int rob4 = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(rob3 + nums[i], rob4);
            rob3 = rob4;
            rob4 = temp;
        }
        return Math.max(rob2, rob4);
    }
}
