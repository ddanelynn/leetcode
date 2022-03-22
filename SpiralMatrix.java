import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = 0;

        int right = cols - 1;
        int bottom = rows - 1;
        int left = 0;
        int top = 0;

        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[r][c]);

            if (r == top && c < right) {
                c++;
            } else if (r < bottom && !(c < right)) {
                r++;
            } else if (r == bottom && c > left) {
                c--;
            } else if (r > top && c == left) {
                r--;
                if (r - 1 == top && c == left) {
                    top++;
                    left++;
                    bottom--;
                    right--;
                }
            }
        }
        return result;
    }
}
