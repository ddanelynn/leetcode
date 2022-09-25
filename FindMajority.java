public class FindMajority {
    public static void main(String[] args) {
        System.out.println(findMajority(new int[] { 4, 3, 3, 3, 4 }));
    }

    public static int findMajority(int[] arr) {
        int majority = arr[0];
        int counter = 1;
        for (int i = 1; i < arr.length; i++) {
            if (counter == 0) {
                majority = arr[i];
            }
            if (arr[i] == majority) {
                counter++;
            } else {
                counter--;
            }
        }
        return majority;
    }
}
