var numIslands = function(grid) {
    let count = 0;
    let visited = new Array(grid.length);
    for (let i = 0; i < grid.length; i++) {
        const row = new Array(grid[0].length);
        for (let j = 0; j < grid[0].length; j++) {
            row[j] = 0;
        }
        visited[i] = row;
    }
    
    
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === "1" && visited[i][j] === 0) {
                bfs(grid, visited, new Coordinate(i, j));
                count++;
            }
        }
    }
    
    return count;
};

var bfs = function(grid, visited, start) {
    const x = [0, 0, 1, -1];
    const y = [1, -1, 0, 0];
    
    const queue = [];
    queue.push(start);
    visited[start.x][start.y] = 1;
    
    while (queue.length) {
        const currCoor = queue.shift();
        for (let i = 0; i < 4; i++) {
            const newX = currCoor.x + x[i];
            const newY = currCoor.y + y[i];
            
            if (newX >= 0 && newX < grid.length && newY >=0 && newY < grid[0].length) {
                if (visited[newX][newY] === 0 && grid[newX][newY] === "1") {
                    visited[newX][newY] = 1;
                    queue.push(new Coordinate(newX, newY));
                }
            }
        }
    }    
}

function Coordinate(x, y) {
    this.x = x;
    this.y = y;
}