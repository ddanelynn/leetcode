var uniquePaths = function(m, n) {
    if (m === n & n === 1) {
        return 1;
    }
    const pathCount = new Array(m);
    const firstRow = new Array(n);
    firstRow[0] = 0;

    for (var i = 1; i < n; i++) {
        firstRow[i] = 1;
    }
    pathCount[0] = firstRow;

    for (var i = 1; i < m; i++) {
        const row = new Array(n);
        row[0] = 1;
        pathCount[i] = row;
    }

    for (var i = 1; i < m; i++) {
        for (var j = 1; j < n; j++) {
            pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
        }
    }

    return pathCount[m - 1][n - 1];

};