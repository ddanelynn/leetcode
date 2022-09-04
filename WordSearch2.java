import java.util.*;

public class WordSearch2 {
    // public static class TrieNode {
    // HashMap<Character, TrieNode> children;
    // boolean isWord;

    // public TrieNode() {
    // this.children = new HashMap<>();
    // this.isWord = false;
    // }

    // public void addWord(String word) {
    // TrieNode curr = this;
    // for (int i = 0; i < word.length(); i++) {
    // char c = word.charAt(i);
    // if (!curr.children.containsKey(c)) {
    // curr.children.put(c, new TrieNode());
    // }
    // curr = curr.children.get(c);
    // }
    // curr.isWord = true;
    // }
    // }

    // public static List<String> findWords(char[][] board, String[] words) {
    // TrieNode root = new TrieNode();
    // for (String word : words) {
    // root.addWord(word);
    // }

    // int[][] visited = new int[board.length][board[0].length];
    // for (int m = 0; m < board.length; m++) {
    // for (int n = 0; n < board[0].length; n++) {
    // visited[m][n] = 0;
    // }
    // }

    // HashSet<String> result = new HashSet<>();
    // for (int i = 0; i < board.length; i++) {
    // for (int j = 0; j < board[0].length; j++) {
    // dfs(board, i, j, result, visited, root, "");
    // }
    // }

    // List<String> resultList = new ArrayList<>();
    // for (String word : result) {
    // resultList.add(word);
    // }

    // return resultList;
    // }

    // public static void dfs(char[][] board, int x, int y, HashSet<String> result,
    // int[][] visited, TrieNode node,
    // String word) {
    // if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
    // visited[x][y] == 1
    // || !node.children.containsKey(board[x][y])) {
    // return;
    // }

    // visited[x][y] = 1;

    // word = word + board[x][y];
    // node = node.children.get(board[x][y]);
    // if (node.isWord) {
    // result.add(word);
    // }
    // dfs(board, x + 1, y, result, visited, node, word);
    // dfs(board, x - 1, y, result, visited, node, word);
    // dfs(board, x, y + 1, result, visited, node, word);
    // dfs(board, x, y - 1, result, visited, node, word);
    // visited[x][y] = 0;
    // }

    // slower method
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
                if (starting.contains(board[i][j])) {
                    int[][] visited = new int[board.length][board[0].length];
                    for (int m = 0; m < board.length; m++) {
                        for (int n = 0; n < board[0].length; n++) {
                            visited[m][n] = 0;
                        }
                    }
                    dfs(board, i, j, maxLength, xMove, yMove, wordSet, "", result, visited);
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for (String word : result) {
            resultList.add(word);
        }

        return resultList;
    }

    public static void dfs(char[][] board, int x, int y, int depth, int[] xMove,
            int[] yMove, HashSet<String> wordSet,
            String word, HashSet<String> result, int[][] visited) {
        if (depth == 0) {
            return;
        }
        visited[x][y] = 1;
        word = word + board[x][y];
        System.out.println(word);
        if (wordSet.contains(word)) {
            result.add(word);
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + xMove[i];
            int newY = y + yMove[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                    && visited[newX][newY] == 0) {
                dfs(board, newX, newY, depth - 1, xMove, yMove, wordSet, word, result,
                        visited);
            }
        }
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = new String[] { "oath", "pea", "eat", "rain" };
        findWords(board, words);
    }
}
