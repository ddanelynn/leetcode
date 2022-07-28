import java.util.*;

class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        ArrayList<Set<Character>> setArr = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            Set<Character> numberSet = new HashSet<>();
            setArr.add(numberSet);
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (setArr.get(i).contains(board[i][j])) {
                    return false;
                }
                setArr.get(i).add(board[i][j]);
                if (setArr.get(9 + j).contains(board[i][j])) {
                    return false;
                }
                setArr.get(9 + j).add(board[i][j]);
                
                if (setArr.get(i/3 * 3 + (int)Math.ceil((double)(j + 1)/3d) + 17).contains(board[i][j])) {
                    return false;
                }
                setArr.get(i/3 * 3 + (int)Math.ceil((double)(j + 1)/3d) + 17).add(board[i][j]);
             
                
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double a = 2d;
        double b = 3d;
        System.out.println(Math.ceil(a/b));
        char[][] board = new char[][]{
            new char[]{'5','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'}};
        
        isValidSudoku(board);
    }
}