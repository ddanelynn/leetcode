public class UniquePaths {
    public int uniquePaths(int m, int n) {

        if (m == n && m == 1) {
            return 1;
        }

        int[][] pathCount = new int[m][n];
        pathCount[0][0] = 0;
        for (int i = 1; i < m; i++) {
            pathCount[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            pathCount[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
            }
        }

        return pathCount[m - 1][n - 1];
    }
}
