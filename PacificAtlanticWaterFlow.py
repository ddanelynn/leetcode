def pacificAtlantic(heights):
        """
        :type heights: List[List[int]]
        :rtype: List[List[int]]
        """
        aGrid = []
        pGrid = []
        for i in range(len(heights)):
            aGrid.append([])
            pGrid.append([])
            for j in range(len(heights[0])):
                aGrid[i].append(0)
                pGrid[i].append(0)
        
        for m in range(len(heights[0])):
            bfs(aGrid, len(heights) - 1, m, heights)
        for m in range(len(heights)):
            bfs(aGrid, m, len(heights[0]) - 1, heights)
        for m in range(len(heights[0])):
            bfs(pGrid, 0, m, heights)
        for m in range(len(heights)):
            bfs(pGrid, m, 0, heights)

        print(aGrid)
        print(pGrid)
        
        result = []
        for i in range(len(heights)):
            for j in range(len(heights[0])):
                if aGrid[i][j] == 1 and pGrid[i][j] == 1:
                    result.append([i, j])
        return result
        
                            
def bfs(visited, currX, currY, heights):
    x = [0, 0, 1, -1]
    y = [1, -1, 0, 0]
    
    visited[currX][currY] = 1
    q = [(currX, currY)]

    while q:
        (currX, currY) = q.pop(0)
        for k in range(4):
            newX = currX + x[k]
            newY = currY + y[k]
            if newX >= 0 and newX < len(heights) and newY >= 0 and newY < len(heights[0]):
                if visited[newX][newY] == 0 and heights[currX][currY] <= heights[newX][newY]:
                    visited[newX][newY] = 1
                    q.append((newX, newY))
def main():
    pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]])

if __name__ == "__main__":
    main()