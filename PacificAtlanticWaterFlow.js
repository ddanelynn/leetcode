var pacificAtlantic = function(heights) {
    
    const pacificVisited = new Array(heights.length);
    const atlanticVisited = new Array(heights.length);
    
    for (let i = 0; i < heights.length; i++) {
        const pacificRow = new Array(heights[0].length);
        const atlanticRow = new Array(heights[0].length);
        for (let j = 0; j < heights[0].length; j++) {
            pacificRow[j] = 0;
            atlanticRow[j] = 0;
        }
        pacificVisited[i] = (pacificRow);
        atlanticVisited[i] = (atlanticRow);
    }
    
    for (let i = 0; i < heights.length; i++) {
        dfs(heights, pacificVisited, new Coordinate(i, 0));
        dfs(heights, atlanticVisited, new Coordinate(i, heights[0].length - 1));
    }
    
    for (let i = 0; i < heights[0].length; i++) {
        dfs(heights, pacificVisited, new Coordinate(0, i));
        dfs(heights, atlanticVisited, new Coordinate(heights.length - 1, i));
    }
    
    const result = [];
    
    for (let i = 0; i < heights.length; i++) {
        for (let j = 0; j < heights[0].length; j++) {
            if (pacificVisited[i][j] === atlanticVisited[i][j] && atlanticVisited[i][j] === 1) {
                const pair = [i, j];
                result.push(pair);
            }
        }
    }
    
    return result;

    
};

function Coordinate(r, c) {
    this.r = r;
    this.c = c;
}

var dfs = function(heights, visited, start) {
    const r = [1, -1, 0, 0];
    const c = [0, 0, 1, -1];
    
    visited[start.r][start.c] = 1;
    const height = heights[start.r][start.c];
    
    for (let i = 0; i < 4; i++) {
        const newR = start.r + r[i];
        const newC = start.c + c[i];

        if (newR >= 0 && newR < heights.length && newC >= 0 && newC < heights[0].length) {

            if (visited[newR][newC] === 0 && heights[newR][newC] >= height) {

                dfs(heights, visited, new Coordinate(newR, newC));
            }
        }
    }
}