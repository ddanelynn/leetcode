public class MaxProductSubArray {
    public static int countSubArrays(int[] arr, int max) {
        int count = 0; // 1
        int left = 0;
        int right = 0;
        int currProd = 1;

        while (right < arr.length) {
            currProd *= arr[right];
            if (currProd <= max) {
                count += (right - left + 1);
                right++;
            } else {
                currProd = currProd / arr[left] / arr[right];
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 3, 2 };
        System.out.println(countSubArrays(arr, 8));
    }
}
