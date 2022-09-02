import java.util.*;

public class Tetris {
    public enum PieceType {
        T,
        I,
        O,
        Z,
        S,
        L,
        J
    }

    public static class Game {
        int row;
        int col;
        Piece[][] board;

        public Game(int row, int col) {
            this.row = row;
            this.col = col;
            this.board = new Piece[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    this.board[i][j] = new Piece();
                }
            }
        }

        public boolean insertPiece(Piece p, int c) {
            int pieceLength = p.baseLineCoordinates.size();
            int stoppingRow = 0;
            int stoppingCol = c;
            for (int i = row - 1; i >= 0; i--) {
                boolean reachBottom = false;
                for (int j = 0; j < pieceLength; j++) {
                    int currRow = i + p.baseLineCoordinates.get(j);
                    int currCol = c + j;
                    if (currRow < 0 || board[currRow][currCol].type != null) {
                        stoppingRow = currRow + 1;
                        stoppingCol = currCol;
                        reachBottom = true;
                        break;
                    }
                }
                if (reachBottom) {
                    break;
                }
            }
            if (stoppingRow >= row) {
                return false;
            }

            int lowAffected = row;
            int highAffected = 0;

            for (int i = c; i < c + pieceLength; i++) {
                int rowDiff = p.baseLineCoordinates.get(stoppingCol - c) - p.baseLineCoordinates.get(i - c);
                for (int j = 0; j < p.coloumnBlockNum.get(i - c); j++) {
                    int checkRow = stoppingRow - rowDiff + j;
                    board[checkRow][i] = p;
                    if (checkRow > highAffected) {
                        highAffected = checkRow;
                    }

                    if (checkRow < lowAffected) {
                        lowAffected = checkRow;
                    }

                }
            }
            checkAffectedRows(lowAffected, highAffected);

            return true;
        }

        public void shift(int r) {
            for (int i = r + 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i - 1][j] = board[i][j];
                }
            }

            for (int j = 0; j < col; j++) {
                board[row - 1][j] = new Piece();
            }
        }

        public void checkAffectedRows(int lowAffected, int highAffected) {
            for (int i = lowAffected; i <= highAffected; i++) {
                if (checkDeleteRow(i)) {
                    i--;
                    highAffected--;
                }
            }
        }

        public boolean checkDeleteRow(int r) {
            boolean filled = true;
            for (int i = 0; i < col; i++) {
                if (board[r][i].type == null) {
                    filled = false;
                }
            }
            if (filled) {
                shift(r);
                return true;
            }
            return false;
        }

        public void printLine() {
            for (int i = 0; i < col; i++) {
                System.out.print("===");
            }
            System.out.println();
        }

        public void printBoard() {
            printLine();
            for (int i = this.row - 1; i >= 0; i--) {
                for (int j = 0; j < this.col; j++) {
                    System.out.print("|" + board[i][j] + "|");
                }
                System.out.println();
            }
            printLine();
        }
    }

    public static class Piece {
        PieceType type;
        int rotation;
        ArrayList<Integer> baseLineCoordinates = new ArrayList<>();
        ArrayList<Integer> coloumnBlockNum = new ArrayList<>();

        public Piece() {
        };

        public Piece(int rotation, PieceType type) {
            this.type = type;
            this.rotation = rotation;
            this.baseLineCoordinates = new ArrayList<>();
            this.coloumnBlockNum = new ArrayList<>();
        }

        public void initBaseLineCoordinates() {
            if (this.type == PieceType.T) {
                initTBaseLineCoordinates();
            } else if (this.type == PieceType.I) {
                initIBaseLineCoordinates();
            } else if (this.type == PieceType.O) {
                initOBaseLineCoordinates();
            } else if (this.type == PieceType.Z) {
                initZBaseLineCoordinates();
            } else if (this.type == PieceType.S) {
                initSBaseLineCoordinates();
            } else if (this.type == PieceType.L) {
                initLBaseLineCoordinates();
            } else if (this.type == PieceType.J) {
                initJBaseLineCoordinates();
            }
        }

        public void initTBaseLineCoordinates() {
            if (this.rotation == 0) {
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(0);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 1) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-2);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(3);
            } else if (this.rotation == 2) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 3) {
                baseLineCoordinates.add(-2);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(3);
                coloumnBlockNum.add(1);
            }
        }

        public void initIBaseLineCoordinates() {
            if (this.rotation == 0 || this.rotation == 2) {
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(0);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 1 || this.rotation == 3) {
                baseLineCoordinates.add(-3);
                coloumnBlockNum.add(4);
            }
        }

        public void initOBaseLineCoordinates() {
            if (this.rotation == 0 || this.rotation == 1 || this.rotation == 2 || this.rotation == 3) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(2);
            }
        }

        public void initZBaseLineCoordinates() {
            if (this.rotation == 0 || this.rotation == 2) {
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 1 || this.rotation == 3) {
                baseLineCoordinates.add(-2);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(2);
            }
        }

        public void initSBaseLineCoordinates() {
            if (this.rotation == 0 || this.rotation == 2) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(0);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 1 || this.rotation == 3) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-2);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(2);
            }
        }

        public void initLBaseLineCoordinates() {
            if (this.rotation == 0) {
                baseLineCoordinates.add(-2);
                baseLineCoordinates.add(-2);
                coloumnBlockNum.add(3);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 1) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(0);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 2) {
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(-2);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(3);
            } else if (this.rotation == 3) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
            }
        }

        public void initJBaseLineCoordinates() {
            if (this.rotation == 0) {
                baseLineCoordinates.add(-2);
                baseLineCoordinates.add(-2);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(3);
            } else if (this.rotation == 1) {
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(2);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 2) {
                baseLineCoordinates.add(-2);
                baseLineCoordinates.add(0);
                coloumnBlockNum.add(3);
                coloumnBlockNum.add(1);
            } else if (this.rotation == 3) {
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(0);
                baseLineCoordinates.add(-1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(1);
                coloumnBlockNum.add(2);
            }
        }

        @Override
        public String toString() {
            if (this.type == PieceType.T) {
                return "T";
            } else if (this.type == PieceType.I) {
                return "I";
            } else if (this.type == PieceType.O) {
                return "O";
            } else if (this.type == PieceType.Z) {
                return "Z";
            } else if (this.type == PieceType.S) {
                return "S";
            } else if (this.type == PieceType.L) {
                return "L";
            } else if (this.type == PieceType.J) {
                return "J";
            }
            return " ";
        }
    }

    public static void main(String[] args) {
        HashMap<String, PieceType> typeMap = new HashMap<>();
        typeMap.put("T", PieceType.T);
        typeMap.put("I", PieceType.I);
        typeMap.put("O", PieceType.O);
        typeMap.put("Z", PieceType.Z);
        typeMap.put("S", PieceType.S);
        typeMap.put("L", PieceType.L);
        typeMap.put("J", PieceType.J);

        // Type
        // Rotation
        // Column
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nunmber of rows in board:");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Enter nunmber of columns in board:");
        int col = Integer.parseInt(sc.nextLine());

        Game game = new Game(row, col);

        boolean isInsertionSuccessful = true;
        while (isInsertionSuccessful) {
            System.out.println("Enter type of piece to insert:");
            PieceType type = typeMap.get(sc.nextLine());
            System.out.println("Enter nunmber of rotations:");
            int rotation = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the column at which the piece is to be inserted:");
            int insertionCol = Integer.parseInt(sc.nextLine());

            Piece p = new Piece(rotation, type);
            p.initBaseLineCoordinates();
            if (!game.insertPiece(p, insertionCol)) {
                isInsertionSuccessful = false;
            }
            game.printBoard();
        }
        System.out.println("Game has ended!");
        sc.close();

    }

}
