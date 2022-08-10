public class SortColours {

    // Merge sort
    // public void sortColors(int[] nums) {
    // mergeSort(nums, 0, nums.length - 1);
    // }

    // public static void mergeSort(int[] a, int i, int j) {
    // if (i < j) {
    // int mid = (i + j) / 2;
    // mergeSort(a, i, mid);
    // mergeSort(a, mid + 1, j);
    // merge(a, i, mid, j);
    // }
    // }

    // public static void merge(int[] a, int i, int mid, int j) {
    // int[] temp = new int[j - i + 1];
    // int left = i, right = mid + 1, it = 0;
    // while (left <= mid && right <= j) {
    // if (a[left] <= a[right]) {
    // temp[it++] = a[left++];
    // } else {
    // temp[it++] = a[right++];
    // }
    // }

    // while (left <= mid) {
    // temp[it++] = a[left++];
    // }
    // while (right <= j) {
    // temp[it++] = a[right++];
    // }

    // for (int k = 0; k < temp.length; k++) {
    // a[i + k] = temp[k];
    // }
    // }

    // public void sortColors(int[] nums) {
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // for (int num : nums) {
    // if (hm.containsKey(num)) {
    // hm.put(num, hm.get(num) + 1);
    // } else {
    // hm.put(num, 1);
    // }
    // }

    // int[] temp = new int[nums.length];
    // int redCount = hm.containsKey(0) ? hm.get(0) : 0;
    // int whiteCount = hm.containsKey(1) ? hm.get(1) : 0;
    // int blueCount = hm.containsKey(2) ? hm.get(2) : 0;
    // for (int i = 0; i < redCount; i++) {
    // temp[i] = 0;
    // }

    // for (int i = 0; i < whiteCount; i++) {
    // temp[redCount + i] = 1;
    // }

    // for (int i = 0; i < blueCount; i++) {
    // temp[redCount + whiteCount + i] = 2;
    // }

    // for (int i = 0; i < nums.length; i++) {
    // nums[i] = temp[i];
    // }
    // }

    // public void sortColors(int[] nums) {
    // ArrayList<Integer> arr = new ArrayList<>();
    // for (int num : nums) {
    // if (num == 0) {
    // arr.add(0);
    // }
    // }

    // for (int num : nums) {
    // if (num == 1) {
    // arr.add(1);
    // }
    // }

    // for (int num : nums) {
    // if (num == 2) {
    // arr.add(2);
    // }
    // }

    // for (int i = 0; i < nums.length; i++) {
    // nums[i] = arr.get(i);
    // }
    // }

    // 100% solution
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low++] = 0;
                nums[mid++] = temp;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high--] = 2;
                nums[mid] = temp;
            }
        }

        // --------------- low mid high
        // 2, 1, 1, 2, 2 -- 0 - 0 - 4
        // 2, 1, 1, 2, 2 -- 0 - 0 - 3
        // 2, 1, 1, 2, 2 -- 0 - 0 - 2
        // 1, 1, 2, 2, 2 -- 0 - 0 - 1
        // 1, 1, 2, 2, 2 -- 0 - 0 - 0
    }
}
