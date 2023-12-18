package advent.year2023.day18.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day18/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day18/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> strings = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) strings.add(s);
            }
            printer.println(solve(parse(strings)));
        }
    }

    private static int[][] parse(List<String> strings) {
        int n = strings.size();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] split = strings.get(i).split(" +");
            int[] moves = new int[3];
            switch (split[0].charAt(0)) {
                case 'L' -> moves[1] = -1;
                case 'D' -> moves[0] = 1;
                case 'R' -> moves[1] = 1;
                case 'U' -> moves[0] = -1;
                default -> throw new RuntimeException();
            }
            moves[2] = Integer.parseInt(split[1]);
            arr[i] = moves;
        }
        return arr;
    }

    private static int solve(int[][] input) {
        int minI = 0, maxI = 0, minJ = 0, maxJ = 0;
        int currI = 0, currJ = 0;
        for (int[] move : input) {
            currI += move[0] * move[2];
            currJ += move[1] * move[2];
            minI = Math.min(minI, currI);
            minJ = Math.min(minJ, currJ);
            maxI = Math.max(maxI, currI);
            maxJ = Math.max(maxJ, currJ);
        }

        int diffI = maxI - minI + 1;
        int diffJ = maxJ - minJ + 1;
        int[][] visited = new int[diffI][diffJ];
        currI = -minI;
        currJ = -minJ;
        visited[currI][currJ] = 2;
        for (int[] move : input) {
            for (int i = 0; i < move[2]; i++) {
                currI += move[0];
                currJ += move[1];
                visited[currI][currJ] = 2;
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < diffI; i++) {
            if (visited[i][0] == 0) {
                visited[i][0] = 1;
                deque.offer(new int[]{i, 0});
            }
            if (visited[i][diffJ - 1] == 0) {
                visited[i][diffJ - 1] = 1;
                deque.offer(new int[]{i, diffJ - 1});
            }
        }

        for (int j = 0; j < diffJ; j++) {
            if (visited[0][j] == 0) {
                visited[0][j] = 1;
                deque.offer(new int[]{0, j});
            }
            if (visited[diffI - 1][j] == 0) {
                visited[diffI - 1][j] = 1;
                deque.offer(new int[]{diffI - 1, j});
            }
        }

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int i = poll[0], j = poll[1];
            for (int k = 0; k < 4; k++) {
                int i1 = i + moves[k], j1 = j + moves[k + 1];
                if (i1 < 0 || j1 < 0 || i1 >= diffI || j1 >= diffJ || visited[i1][j1] != 0) continue;
                visited[i1][j1] = 1;
                deque.offer(new int[]{i1, j1});
            }
        }

        int ans = 0;
        for (int[] row : visited) for (int val : row) if (val == 2 || val == 0) ans++;
        return ans;
    }
}
