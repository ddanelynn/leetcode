import java.util.*;

public class InifiniteConnectN {

    public enum Colour {
        WHITE,
        BLACK
    }

    public static class Board {
        int height;
        int rightMost;
        int leftMost;
        int winCount;
        int maxMoves;
        HashMap<String, ArrayList<Colour>> board;

        public Board(int winCount, int maxMoves) {
            this.height = 0;
            this.rightMost = Integer.MIN_VALUE;
            this.leftMost = Integer.MAX_VALUE;
            this.winCount = winCount;
            this.maxMoves = maxMoves;
            this.board = new HashMap<>();
        }

        public void insertPin(String column, Colour colour) {
            if (this.board.containsKey(column)) {
                this.board.get(column).add(colour);
            } else {
                ArrayList<Colour> col = new ArrayList<>();
                col.add(colour);
                this.board.put(column, col);
            }
            if (this.board.get(column).size() > this.height) {
                this.height = this.board.get(column).size();
            }

            if (Integer.parseInt(column) > this.rightMost) {
                this.rightMost = Integer.parseInt(column);
            }

            if (Integer.parseInt(column) < this.leftMost) {
                this.leftMost = Integer.parseInt(column);
            }
        }

        public boolean checkWin(String column) {
            int height = this.board.get(column).size();
            Colour colour = this.board.get(column).get(height - 1);
            int horizontal = this.checkLeft(column, height - 1, colour)
                    + this.checkRight(column, height - 1, colour) + 1;
            int vertical = this.checkDown(column, height - 1, colour) + 1;
            int diagonal1 = this.checkLeftUp(column, height - 1, colour)
                    + this.checkRightDown(column, height - 1, colour) + 1;
            int diagonal2 = this.checkLeftDown(column, height - 1, colour)
                    + this.checkRightUp(column, height - 1, colour) + 1;

            if (horizontal == this.winCount ||
                    vertical == this.winCount ||
                    diagonal1 == this.winCount ||
                    diagonal2 == this.winCount) {
                return true;
            }

            return false;
        }

        public int checkLeft(String column, int heightIndex, Colour colour) {
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) - i - 1);
                if (this.board.containsKey(newKey) &&
                        this.board.get(newKey).size() > heightIndex &&
                        this.board.get(newKey).get(heightIndex) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRight(String column, int heightIndex, Colour colour) {
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) + i + 1);
                if (this.board.containsKey(newKey) &&
                        this.board.get(newKey).size() > heightIndex &&
                        this.board.get(newKey).get(heightIndex) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkDown(String column, int heightIndex, Colour colour) {
            if (heightIndex == 0) {
                return 0;
            }
            int count = 0;
            for (int i = heightIndex - 1; i >= 0; i--) {
                if (this.board.get(column).get(i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkLeftUp(String column, int heightIndex, Colour colour) {
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) - i - 1);
                if (this.board.containsKey(newKey) &&
                        this.board.get(newKey).size() > heightIndex + 1 + i &&
                        this.board.get(newKey).get(heightIndex + 1 + i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRightUp(String column, int heightIndex, Colour colour) {
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) + i + 1);
                if (this.board.containsKey(newKey) &&
                        this.board.get(newKey).size() > heightIndex + 1 + i &&
                        this.board.get(newKey).get(heightIndex + 1 + i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkLeftDown(String column, int heightIndex, Colour colour) {
            if (heightIndex == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) - i - 1);
                if (this.board.containsKey(newKey) &&
                        heightIndex - 1 - i >= 0 &&
                        this.board.get(newKey).size() > heightIndex - 1 - i &&
                        this.board.get(newKey).get(heightIndex - 1 - i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public int checkRightDown(String column, int heightIndex, Colour colour) {
            if (heightIndex == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < this.winCount - 1; i++) {
                String newKey = String.valueOf(Integer.parseInt(column) + i + 1);
                if (this.board.containsKey(newKey) &&
                        heightIndex - 1 - i >= 0 &&
                        this.board.get(newKey).size() > heightIndex - 1 - i &&
                        this.board.get(newKey).get(heightIndex - 1 - i) == colour) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public void printLine() {
            for (int i = 0; i < (this.rightMost - this.leftMost + 1); i++) {
                System.out.print("=======");
            }
            System.out.println();
        }

        public void printBoard() {
            printLine();
            for (int i = this.height - 1; i >= 0; i--) {
                for (int j = this.leftMost; j < this.rightMost + 1; j++) {
                    if (!this.board.containsKey(String.valueOf(j)) || this.board.get(String.valueOf(j)).size() <= i) {
                        System.out.print("|     |");
                    } else {
                        System.out.print("|" + colourToString(this.board.get(String.valueOf(j)).get(i)) + "|");
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

    public static Board gameSetUp(Scanner sc) {
        System.out.println("Welcome to Connect N Game! Let's set up the game!");

        int winCount = handleInput(sc, "What would you want your connection count to be?");
        int maxMoves = handleInput(sc, "What would you want your maximum number of moves to be?");

        System.out.println("Thank you for your input. Game set up is done!");
        Board game = new Board(winCount, maxMoves);
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

    public static String validateMove(Scanner sc, Board board, String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine();
        String regex = "-?[0-9]*";

        while (!input.matches(regex)) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.println(prompt);
            input = sc.nextLine();
        }
        return input;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Board game = gameSetUp(sc);

        int pinNum = 0;
        Colour colour = Colour.BLACK;
        boolean hasWinner = false;

        while (pinNum < game.maxMoves) {
            System.out.println(
                    "It's " + colourToString(colour) + "'s turn!");
            String column = validateMove(sc, game, "Which column do you want to drop your pin at?");
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
