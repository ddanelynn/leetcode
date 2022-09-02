import java.util.*;

public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        int maxLength = 0;
        HashSet<Character> starting = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            starting.add(word.charAt(0));
            wordSet.add(word);
        }
        HashSet<String> result = new HashSet<>();
        int[] xMove = new int[] { 1, -1, 0, 0 };
        int[] yMove = new int[] { 0, 0, 1, -1 };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if (starting.contains(board[i][j])) {
                if (board[i][j] == 'a') {
                    int[][] visited = new int[board.length][board[0].length];
                    for (int m = 0; m < board.length; m++) {
                        for (int n = 0; n < board[0].length; n++) {
                            visited[m][n] = 0;
                        }
                    }
                    dfs(board, i, j, 4, xMove, yMove, wordSet, "", result, visited);
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for (String word : result) {
            resultList.add(word);
        }

        return resultList;
    }

    public static void dfs(char[][] board, int x, int y, int depth, int[] xMove, int[] yMove, HashSet<String> wordSet,
            String word, HashSet<String> result, int[][] visited) {
        visited[x][y] = 1;
        System.out.println("depth" + depth);
        if (depth == 0) {
            for (int m = 0; m < board.length; m++) {
                for (int n = 0; n < board[0].length; n++) {
                    visited[m][n] = 0;
                }

            }
            return;
        }
        word = word + board[x][y];
        System.out.println(word);
        if (wordSet.contains(word)) {
            result.add(word);
        }
        for (int i = 0; i < 4; i++) {

            int newX = x + xMove[i];
            int newY = y + yMove[i];
            if (x == 0 && y == 0) {
                System.out.println(i);
                System.out.println(newX + " " + newY);
                System.out.println(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length);
                for (int m = 0; m < board.length; m++) {
                    for (int n = 0; n < board[0].length; n++) {
                        System.out.print(visited[m][n] + " ");
                    }
                    System.out.println();
                }
            }
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && visited[newX][newY] == 0) {
                dfs(board, newX, newY, depth - 1, xMove, yMove, wordSet, word, result, visited);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'a', 'b' },
                { 'c', 'd' } };
        String[] words = new String[] { "abcdefg", "befa", "eaabcdgfa", "gfedcbaaa" };
        findWords(board, words);
    }
}
