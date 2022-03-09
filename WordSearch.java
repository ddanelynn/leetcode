import java.util.*;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        
        ArrayList<Integer> rowArr = new ArrayList<>();
        ArrayList<Integer> colArr = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    rowArr.add(i);
                    colArr.add(j);
                }
            }
        }


        if (word.length() == 0) {
            return false;
        }

        if (word.length() == 1) {
            return rowArr.size() >= 1;
        }

        for (int i = 0; i < rowArr.size(); i++) {
            int[][] visited = new int[board.length][board[0].length];

            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    visited[r][c] = 0;
                }
            }
            if (dfs(board, 0, visited, rowArr.get(i), colArr.get(i), word)) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int checkingIndex, int[][] visited, int currentRow, int currentCol, String word) {

        if (checkingIndex == word.length()) {
            return true;
        }
        
        if (currentRow < 0 || currentRow >= board.length ||
            currentCol < 0 || currentCol >= board[0].length ||
            word.charAt(checkingIndex) != board[currentRow][currentCol] ||
            visited[currentRow][currentCol] == 1) {
                return false;
        }

        visited[currentRow][currentCol] = 1;

        boolean result = dfs(board, checkingIndex + 1, visited, currentRow, currentCol + 1, word) ||
                         dfs(board, checkingIndex + 1, visited, currentRow + 1, currentCol, word) ||
                         dfs(board, checkingIndex + 1, visited, currentRow, currentCol - 1, word) ||
                         dfs(board, checkingIndex + 1, visited, currentRow - 1, currentCol, word);

        visited[currentRow][currentCol] = 0;
        
        return result;
    }

    public static void main (String[] args) {
        char[][] board = {{'A','B', 'C', 'E'},{'S','F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // char[][] board = {{'A','A'}};
        // char[][] board = {{'C','A', 'A'},{'A','A', 'A'}, {'B', 'C', 'D'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
