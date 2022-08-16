class UniquePaths:
    def uniquePaths(self, m: int, n: int) -> int:
        path = []
        for i in range(m):
            row = []
            for j in range(n):
                row.append(1)
            path.append(row)
        
        for i in range(1, m):
            for j in range(1, n):
                path[i][j] = path[i][j - 1] + path[i - 1][j]
        
        return path[m - 1][n - 1]