package advent.day4.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int size = 5;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day4/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day4/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] draws = scanner.nextLine().trim().split(",");
            List<Board> list = new LinkedList<>();
            int left = 0;

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                int[][] mat = new int[size][size];
                for (int i = 0; i < size; i++) {
                    String[] parts = scanner.nextLine().trim().split(" +");
                    for (int j = 0; j < size; j++) mat[i][j] = Integer.parseInt(parts[j]);
                }
                list.add(new Board(mat));
                left++;
            }

            for (String draw : draws) {
                int num = Integer.parseInt(draw);
                ListIterator<Board> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    Board board = iterator.next();
                    if (board.mark(num)) {
                        iterator.remove();
                        if (--left == 0) {
                            printer.println(num * board.sum);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class Board {
        final int[] rows, cols;
        int sum = 0;
        final Map<Integer, Cell> map;

        public Board(int[][] mat) {
            this.rows = new int[size];
            this.cols = new int[size];
            this.map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map.put(mat[i][j], new Cell(i, j));
                    sum += mat[i][j];
                }
            }
        }

        public boolean mark(int num) {
            Cell cell = map.get(num);
            if (cell != null) {
                sum -= num;
                return ++rows[cell.i] == size || ++cols[cell.j] == size;
            }
            return false;
        }
    }

    private record Cell(int i, int j) {
    }
}
