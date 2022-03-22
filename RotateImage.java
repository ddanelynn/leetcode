public class RotateImage {
    public void rotate(int[][] matrix) {
        // 3 x 3
        // (0, 0) -> (0, 2) -> (2, 2) -> (2, 0)
        // (0, 1) -> (1, 2) -> (2, 1) -> (1, 0)
 
        // 4 x 4
        // (0, 0) -> (0, 3) -> (3, 3) -> (3, 0)
        // (0, 1) -> (1, 3) -> (3, 2) -> (2, 0)
        // (1, 0) -> (0, 2) -> (2, 3) -> (3, 1)
        // (1, 1) -> (1, 2) -> (2, 2) -> (2, 1)

        // (x, y) -> (y, n - 1 - x) -> (n - 1 - x, n - 1 - y)

        int n = matrix.length;
        int rotationX = 0;
        int rotationY = 0;
        if (n % 2 == 0) {
            // even
            rotationX = n/2;
            rotationY = n/2;
        } else {
            // odd
            rotationX = n/2;
            rotationY = n/2 + 1;
        }

        for (int i = 0; i < rotationX; i++) {
            for (int j = 0; j < rotationY; j++) {
                int rotationCount = 4;
                int r = i;
                int c = j;
                int temp = matrix[n - 1 - c][r];
                while (rotationCount > 0) {
                    int temp2 = matrix[r][c];
                    matrix[r][c] = temp;
                    int rCopy = r;
                    r = c;
                    c = n - 1 - rCopy;
                    temp = temp2;
                    rotationCount--;
                }
            }
        }

    }
}
