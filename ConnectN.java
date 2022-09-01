import java.util.*;

public class ConnectN {

    public enum Colour {
        WHITE,
        BLACK
    }

    public static class Board {
        int width;
        int height;
        int winCount;
        ArrayList<ArrayList<Colour>> board;

        public Board(int width, int height, int winCount) {
            this.width = width;
            this.height = height;
            this.winCount = winCount;
            this.board = new ArrayList<>();

            for (int i = 0; i < width; i++) {
                ArrayList<Colour> column = new ArrayList<>();
                this.board.add(column);
            }
        }

        public void insertPin(int column, Colour colour) {
            this.board.get(column - 1).add(colour);
        }

        public boolean checkWin(int column) {
            int height = this.board.get(column - 1).size();
            Colour colour = this.board.get(column - 1).get(height - 1);
            int horizontal = this.checkLeft(column - 1, height - 1, colour)
                    + this.checkRight(column - 1, height - 1, colour) + 1;
            int vertical = this.checkDown(column - 1, height - 1, colour) + 1;
            int diagonal1 = this.checkLeftUp(column - 1, height - 1, colour)
                    + this.checkRightDown(column - 1, height - 1, colour) + 1;
            int diagonal2 = this.checkLeftDown(column - 1, height - 1, colour)
                    + this.checkRightUp(column - 1, height - 1, colour) + 1;

            if (horizontal == this.winCount ||
                    vertical == this.winCount ||
                    diagonal1 == this.winCount ||
                    diagonal2 == this.winCount) {
                return true;
            }

            return false;
        }

        public int checkLeft(int columnIndex, int heightIndex, Colour colour) {
            if (columnIndex == 0) {
                return 0;
            }
            int count = 0;
            for (int i = columnIndex - 1; i >= 0; i--) {
                if (this.board.get(i).size() > heightIndex && this.board.get(i).get(heightIndex) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRight(int columnIndex, int heightIndex, Colour colour) {
            if (columnIndex == this.width - 1) {
                return 0;
            }
            int count = 0;
            for (int i = columnIndex + 1; i < this.width; i++) {
                if (this.board.get(i).size() > heightIndex && this.board.get(i).get(heightIndex) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkDown(int columnIndex, int heightIndex, Colour colour) {
            if (heightIndex == 0) {
                return 0;
            }
            int count = 0;
            for (int i = heightIndex - 1; i >= 0; i--) {
                if (this.board.get(columnIndex).get(i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkLeftUp(int columnIndex, int heightIndex, Colour colour) {
            if (heightIndex == this.height - 1 || columnIndex == 0) {
                return 0;
            }
            int count = 0;
            int limit = Math.min(this.height - 1 - heightIndex, columnIndex);
            for (int i = 1; i <= limit; i++) {
                if (this.board.get(columnIndex - i).size() > heightIndex + i
                        && this.board.get(columnIndex - i).get(heightIndex + i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRightUp(int columnIndex, int heightIndex, Colour colour) {
            if (heightIndex == this.height - 1 || columnIndex == this.width - 1) {
                return 0;
            }
            int count = 0;
            int limit = Math.min(this.height - 1 - heightIndex, this.width - 1 - columnIndex);
            for (int i = 1; i <= limit; i++) {
                if (this.board.get(columnIndex + i).size() > heightIndex + i
                        && this.board.get(columnIndex + i).get(heightIndex + i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkLeftDown(int columnIndex, int heightIndex, Colour colour) {
            if (heightIndex == 0 || columnIndex == 0) {
                return 0;
            }
            int count = 0;
            int limit = Math.min(heightIndex, columnIndex);
            for (int i = 1; i <= limit; i++) {
                if (this.board.get(columnIndex - i).size() > heightIndex - i
                        && this.board.get(columnIndex - i).get(heightIndex - i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRightDown(int columnIndex, int heightIndex, Colour colour) {
            if (heightIndex == 0 || columnIndex == this.width - 1) {
                return 0;
            }
            int count = 0;
            int limit = Math.min(heightIndex, this.width - 1 - columnIndex);
            for (int i = 1; i <= limit; i++) {
                if (this.board.get(columnIndex + i).size() > heightIndex - i
                        && this.board.get(columnIndex + i).get(heightIndex - i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public void printLine() {
            for (int i = 0; i < this.width; i++) {
                System.out.print("=======");
            }
            System.out.println();
        }

        public void printBoard() {
            printLine();
            for (int i = this.height - 1; i >= 0; i--) {
                for (int j = 0; j < this.width; j++) {
                    if (this.board.get(j).size() <= i) {
                        System.out.print("|     |");
                    } else {
                        System.out.print("|" + colourToString(this.board.get(j).get(i)) + "|");
                    }
                }
                System.out.println();
            }
            printLine();
        }

    }

    public static Colour toppleColour(Colour colour) {
        if (colour == Colour.BLACK) {
            return Colour.WHITE;
        }
        return Colour.BLACK;
    }

    public static String colourToString(Colour colour) {
        if (colour == Colour.BLACK) {
            return "WHITE";
        }
        return "BLACK";
    }

    public static int validateMove(Scanner sc, Board board, String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine();
        String regex = "[1-9][0-9]*";

        while (!input.matches(regex)) {
            System.out.println("Invalid input. Please enter a positive integer.");
            System.out.println(prompt);
            input = sc.nextLine();
        }
        int column = Integer.parseInt(input);
        while (column > board.width || board.board.get(column - 1).size() == board.height) {
            System.out.println("The column is full or the column is invalid.");
            System.out.println(prompt);
            input = sc.nextLine();
            while (!input.matches(regex)) {
                System.out.println("Invalid input. Please enter a positive integer.");
                System.out.println(prompt);
                input = sc.nextLine();
            }
            column = Integer.parseInt(input);
        }
        return column;
    }

    public static Board gameSetUp(Scanner sc) {
        System.out.println("Welcome to Connect N Game! Let's set up the game!");

        int boardWidth = 0;
        int boardHeight = 0;
        int winCount = 1;

        while (winCount > Math.max(boardWidth, boardHeight)) {
            if (boardWidth != 0) {
                System.out.println(
                        "Your connection count has to be smaller than either number of columns or number of rows.");
            }

            boardWidth = handleInput(sc, "How many columns do you want your board to have?");
            boardHeight = handleInput(sc, "How many rows do you want your board to have?");
            winCount = handleInput(sc, "What would you want your connection count to be?");
        }

        System.out.println("Thank you for your input. Game set up is done!");
        System.out.println("Your board will look like this:");
        Board game = new Board(boardWidth, boardHeight, winCount);
        game.printBoard();
        return game;
    }

    public static int handleInput(Scanner sc, String prompt) {
        System.out.println(prompt);
        String regex = "[1-9][0-9]*";
        String input = sc.nextLine();
        while (!input.matches(regex)) {
            System.out.println("Invalid input. Please enter a positive integer.");
            System.out.println(prompt);
            input = sc.nextLine();
        }
        return Integer.parseInt(input);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Board game = gameSetUp(sc);

        int pinNum = 0;
        Colour colour = Colour.BLACK;
        boolean hasWinner = false;

        while (pinNum < game.width * game.height) {
            System.out.println(
                    "It's " + colourToString(colour) + "'s turn!");
            int column = validateMove(sc, game, "Which column do you want to drop your pin at?");
            game.insertPin(column, colour);
            game.printBoard();
            if (game.checkWin(column)) {
                System.out.println(colourToString(colour) + " won!!");
                hasWinner = true;
                break;
            }
            colour = toppleColour(colour);
            pinNum++;
        }
        sc.close();

        if (!hasWinner) {
            System.out.println("End of Game! Draw!");
        }
    }
}
