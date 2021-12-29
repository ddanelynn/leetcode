import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = new int[][] {{2, 1}, {1, 2}};
        System.out.println(pacificAtlantic(heights));
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultList = new ArrayList<>();
        int[][] pacificVisited = new int[heights.length][heights[0].length];
        int[][] atlanticVisited = new int[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                pacificVisited[r][c] = 0;
                atlanticVisited[r][c] = 0;
            }
        }

        for (int r = 0; r < heights.length; r++) {
            Coordinate start = new Coordinate(r, 0);
            dfs(heights, pacificVisited, start);  
        }

        for (int c = 0; c < heights[0].length; c++) {
            Coordinate start = new Coordinate(0, c);
            dfs(heights, pacificVisited, start);  
        }
        

        for (int r = 0; r < heights.length; r++) {
            Coordinate start = new Coordinate(r, heights[0].length - 1);
            dfs(heights, atlanticVisited, start);  
        }

        for (int c = 0; c < heights[0].length; c++) {
            Coordinate start = new Coordinate(heights.length - 1, c);
            dfs(heights, atlanticVisited, start);  
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacificVisited[r][c] == atlanticVisited[r][c] && pacificVisited[r][c] == 1) {
                    List<Integer> coor = new ArrayList<>();
                    coor.add(r);
                    coor.add(c);
                    resultList.add(coor);
                }
            }
        }
        return resultList;
    }

    public static class Coordinate {
        int r;
        int c;
        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void dfs(int[][] heights, int[][] visited, Coordinate start) {
        int[] directionR = new int[]{1, -1, 0, 0};
        int[] directionC = new int[]{0, 0, 1, -1};

        visited[start.r][start.c] = 1;
        int height = heights[start.r][start.c];
        for (int i = 0; i < 4; i++) {
            int newR = start.r + directionR[i];
            int newC = start.c + directionC[i];
            Coordinate newCoor = new Coordinate(newR, newC);
            if (newR >= 0 && newR < heights.length && newC >= 0 && newC < heights[0].length) {
                int newHeight = heights[newR][newC];
                if (height<= newHeight && visited[newR][newC] == 0) {
                    dfs(heights, visited, newCoor);
                }
            } 
        } 
    }
}
