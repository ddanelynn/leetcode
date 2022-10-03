import java.util.Arrays;
import java.util.HashMap;

public class CountBadPairs {
    private static long mergeCount(int[] arr, int left, int mid, int right) {
        int leftIndex = 0, rightIndex = 0, i = left;
        long count = 0;
        int[] leftSubarray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightSubarray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        while (leftIndex < leftSubarray.length && rightIndex < rightSubarray.length) {
            if (leftSubarray[leftIndex] <= rightSubarray[rightIndex])
                arr[i++] = leftSubarray[leftIndex++];
            else {
                arr[i++] = rightSubarray[rightIndex++];
                count += (mid + 1) - (left + leftIndex);
            }
        }
        while (leftIndex < leftSubarray.length)
            arr[i++] = leftSubarray[leftIndex++];
        while (rightIndex < rightSubarray.length)
            arr[i++] = rightSubarray[rightIndex++];

        return count;
    }

    private static int countTotalInversions(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count += countTotalInversions(arr, left, mid);
            count += countTotalInversions(arr, mid + 1, right);
            count += mergeCount(arr, left, mid, right);
        }

        return count;
    }

    // public static int countBadPairs(int[] arr) {
    // int count = 0;
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // for (int i = 0; i < arr.length; i++) {
    // hm.put(arr[i], i);
    // }

    // Arrays.sort(arr);

    // int upper = hm.get(arr[0]);
    // int lower = upper;

    // for (int i = 1; i < arr.length; i++) {
    // if (hm.get(arr[i]) > upper) {
    // upper = hm.get(arr[i]);
    // lower = upper;
    // } else {
    // if (hm.get(arr[i]) < lower) {
    // lower = hm.get(arr[i]);
    // count += upper - lower;
    // }
    // }
    // }

    // return count;
    // }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 6, 4, 8, 5, 10 };
        System.out.println(countTotalInversions(arr, 0, arr.length - 1));

        int[] arr1 = new int[] { 8, 1, 3, 7, 5, 2 };
        System.out.println(countTotalInversions(arr1, 0, arr1.length - 1));

        int[] arr2 = new int[] { 3, 5, 4, 1, 2, 6, 7, 8 };
        System.out.println(countTotalInversions(arr2, 0, arr2.length - 1));
    }
}
