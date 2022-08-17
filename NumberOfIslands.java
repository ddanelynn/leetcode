import java.util.*;

public class NumberOfIslands {
  public static int numIslands(char[][] grid) {
    int[][] visited = new int[grid.length][grid[0].length];
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && visited[i][j] == 0) {
          Coordinate start = new Coordinate(i, j);
          count++;
          bfs(grid, start, visited);
        }
      }
    }
    return count;
  }

  public static void bfs(char[][] grid, Coordinate start, int[][] visited) {
    int[] directionXArr = new int[] { 0, 0, 1, -1 };
    int[] directionYArr = new int[] { 1, -1, 0, 0 };

    Queue<Coordinate> q = new LinkedList<>();
    q.add(start);
    visited[start.x][start.y] = 1;

    while (!q.isEmpty()) {
      Coordinate curr = q.poll();
      for (int i = 0; i < 4; i++) {
        int newX = curr.x + directionXArr[i];
        int newY = curr.y + directionYArr[i];
        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
          if (grid[newX][newY] == '1') {
            if (visited[newX][newY] == 0) {
              Coordinate newCoor = new Coordinate(newX, newY);
              visited[newX][newY] = 1;
              q.add(newCoor);
            }
          }
        }
      }
    }
  }

  public static class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    char[] row1 = { '1', '1', '1', '1', '0' };
    char[] row2 = { '1', '1', '0', '1', '0' };
    char[] row3 = { '1', '1', '0', '0', '0' };
    char[] row4 = { '0', '0', '0', '0', '0' };

    char[][] grid = { row1, row2, row3, row4 };

    numIslands(grid);

  }
}
