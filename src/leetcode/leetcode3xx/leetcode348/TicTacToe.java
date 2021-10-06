package leetcode.leetcode3xx.leetcode348;

public class TicTacToe {
    private final boolean[][] field = new boolean[3][3];
    private int turn = 1, left = 9;
    private final int[] rows = new int[3];
    private final int[] cols = new int[3];
    private int d1 = 0, d2 = 0;
    private boolean ended = false;
    private boolean winner = false;

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (ended) throw new GameEndException();
        if (field[row][col]) throw new AlreadyTakenException();
        field[row][col] = true;
        left--;
        if (
                Math.abs(rows[row] += turn) == 3 ||
                        Math.abs(cols[col] += turn) == 3 ||
                        row == col && Math.abs(d1 += turn) == 3 ||
                        row + col == 2 && Math.abs(d2 += turn) == 3
        ) {
            ended = true;
            winner = turn == 1;
        }
        turn = -turn;
        return ended;
    }
}

class AlreadyTakenException extends Exception {
}

class GameEndException extends Exception {
}
