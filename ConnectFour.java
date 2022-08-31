import java.util.*;

public class ConnectFour {

    public enum Colour {
        WHITE,
        BLACK
    }

    public static class Board {
        int width;
        int height;
        ArrayList<ArrayList<Colour>> board;

        public Board(int width, int height) {
            this.width = width;
            this.height = height;
            this.board = new ArrayList<>();

            for (int i = 0; i < width; i++) {
                ArrayList<Colour> column = new ArrayList<>();
                this.board.add(column);
            }
        }

        public void insertPin(int column, Colour colour) {
            this.board.get(column - 1).add(colour);
        }

        public boolean checkWin(int column, int winCount) {
            int height = this.board.get(column - 1).size();
            Colour colour = this.board.get(column - 1).get(height - 1);
            int horizontal = this.checkLeft(column - 1, height - 1, colour)
                    + this.checkRight(column - 1, height - 1, colour) + 1;
            int vertical = this.checkDown(column - 1, height - 1, colour) + 1;
            int diagonal1 = this.checkLeftUp(column - 1, height - 1, colour)
                    + this.checkRightDown(column - 1, height - 1, colour) + 1;
            int diagonal2 = this.checkLeftDown(column - 1, height - 1, colour)
                    + this.checkRightUp(column - 1, height - 1, colour) + 1;

            if (horizontal == winCount || vertical == winCount || diagonal1 == winCount || diagonal2 == winCount) {
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

    public static boolean validateMove(int column, Board board) {
        if (column > board.width || board.board.get(column - 1).size() == board.height) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("Welcome to Connect N Game! Let's set up the game!");
        Scanner sc = new Scanner(System.in);
        System.out.println("How many columns do you want your board to have?");
        int boardWidth = Integer.parseInt(sc.nextLine());
        System.out.println("How many rows do you want your board to have?");
        int boardHeight = Integer.parseInt(sc.nextLine());
        System.out.println("What would you want your connection count to be?");
        int winCount = Integer.parseInt(sc.nextLine());
        System.out.println("Thank you for your input. Game set up is done!");
        int pinNum = 0;
        Colour colour = Colour.BLACK;
        boolean hasWinner = false;

        Board game = new Board(boardWidth, boardHeight);

        while (pinNum < boardHeight * boardWidth) {
            System.out.println(
                    "It's " + colourToString(colour) + "'s turn, Which column do you want to drop your pin at?");
            int column = Integer.parseInt(sc.nextLine());
            while (!validateMove(column, game)) {
                System.out.println(
                        "This column is full, or your coloumn is invalid, please try again! Which column do you want to drop your pin at?");
                column = Integer.parseInt(sc.nextLine());
            }
            game.insertPin(column, colour);
            game.printBoard();
            if (game.checkWin(column, winCount)) {
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
