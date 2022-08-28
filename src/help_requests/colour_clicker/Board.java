package help_requests.colour_clicker;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class Board {
    private static final int[] moves = {1, 0, -1, 0, 1};
    private final int[][] board;
    // n - столбцов, m - рядов, при обнулении столбец удаляется, а остальные будут свдигаться
    private int m, n;
    private final int[] h; // высотка каждого столбца
    private int left; //количество оставшихся ячеек

    public Board(int[][] board) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        this.h = new int[n];
        this.left = n * m;
        Arrays.fill(h, m);
        processDeletion(new int[n]);
    }

    public Board(int n, int m, int numberOfColours) {
        this.board = new int[n][m];
        this.m = m;
        this.n = n;
        this.left = m * n;
        this.h = new int[n];
        Arrays.fill(h, m);
        Random random = new Random();
        for (int[] row : board) for (int i = 0; i < n; i++) row[i] = 1 + random.nextInt(numberOfColours);
    }

    public void click(int x, int y) {
        int[] minDeleted = markToDelete(x, y);
        processDeletion(minDeleted);
    }

    public BoardState getState() {
        return new BoardState(board, h, n, m);
    }

    // marks deleted cells as zeros
    // return minimal index of deleted cell for every column
    private int[] markToDelete(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int colour = board[x][y];
        board[x][y] = 0;
        queue.add(new int[]{x, y});
        int[] minDeleted = Arrays.copyOf(h, n);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + moves[k], newY = y + moves[k + 1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= h[newX] || board[newX][newY] != colour) continue;
                board[newX][newY] = 0;
                minDeleted[newX] = Math.min(minDeleted[newX], newY);
                queue.offer(new int[]{newX, newY});
            }
        }
        return minDeleted;
    }

    private void processDeletion(int[] minDeleted) {
        //process columns
        for (int i = 0; i < n; i++) {
            int[] row = board[i];
            int i1 = minDeleted[i], i2 = minDeleted[i], prevH = h[i];
            while (i2 < prevH) {
                if (row[i2] != 0) row[i1++] = row[i2];
                else this.left--;
                i2++;
            }
            h[i] = i1;
        }

        //delete empty columns
        int i1 = 0, i2 = 0;
        while (i2 < n) {
            if (h[i2] != 0) {
                board[i1] = board[i2];
                h[i1] = h[i2];
                i1++;
            }
            i2++;
        }
        n = i1;

        m = 0;
        for (int i = 0; i < n; i++) m = Math.max(m, h[i]);
    }

    public static void main(String[] args) {
        System.out.println((10 + 10 >>> 1));
    }

    public record BoardState(int[][] board, int[] h, int n, int m) {
    }
}


