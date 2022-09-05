import java.util.*;

public class SnakeGame {
    int width;
    int height;
    ArrayList<int[]> foodPositions;
    int score;
    Queue<Integer> currX;
    Queue<Integer> currY;

    public SnakeGame(int width, int height, ArrayList<int[]> foodPositions) {
        this.width = width;
        this.height = height;
        this.foodPositions = foodPositions;
        this.score = 0;
        this.currX = new LinkedList<>();
        this.currX.add(0);
        this.currY = new LinkedList<>();
        this.currY.add(0);
    }

    public int move(char direction) {
        int x = currX.peek();
        int y = currY.peek();

        if (direction == 'L') {
            if (y - 1 < 0) {
                return -1;
            }
            y = y - 1;
        } else if (direction == 'R') {
            if (y + 1 >= this.width) {
                return -1;
            }
            y = y + 1;

        } else if (direction == 'U') {
            if (x - 1 < 0) {
                return -1;
            }
            x = x - 1;

        } else if (direction == 'D') {
            if (x + 1 >= this.height) {
                return -1;
            }
            x = x + 1;
        }
        if (x == this.foodPositions.get(this.score)[0] &&
                y == this.foodPositions.get(this.score)[1]) {
            this.score++;
            int qLen = this.currX.size();
            currX.add(x);
            currY.add(y);
            while (qLen > 0) {
                currX.add(currX.poll());
                currY.add(currY.poll());
                qLen--;
            }
        } else {
            int qLen = this.currX.size();
            while (qLen > 1) {
                currX.add(currX.poll());
                currY.add(currY.poll());
                qLen--;
            }
            currX.poll();
            currY.poll();
            if (currX.contains(x) && currY.contains(y)) {
                return -1;
            }
            currX.add(x);
            currY.add(y);
        }
        return this.score;
    }
}
