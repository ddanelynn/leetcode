import java.util.Arrays;
import java.util.HashMap;

public class CountBadPairs {
    public static int countBadPairs(int[] arr) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], i);
        }

        Arrays.sort(arr);

        int upper = hm.get(arr[0]);
        int lower = upper;

        for (int i = 1; i < arr.length; i++) {
            if (hm.get(arr[i]) > upper) {
                upper = hm.get(arr[i]);
                lower = upper;
            } else {
                if (hm.get(arr[i]) < lower) {
                    lower = hm.get(arr[i]);
                    count += upper - lower;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 6, 4, 8, 5, 10 };
        System.out.println(countBadPairs(arr));

        int[] arr1 = new int[] { 8, 1, 3, 7, 5, 2 };
        System.out.println(countBadPairs(arr1));
    }
}
