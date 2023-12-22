package advent.year2023.day21.second;

import basic.utils.ArrayTools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.max;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    private static final int STEPS = 26501365;
    private static final int N = 131;
    private static final int n = (N - 3) / 2;
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day21/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day21/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> input = parseInput(scanner);
//            checkInput(input);
            printer.println(solve(input));
        }
    }

    private static void checkInput(List<String> input) {
        int n = input.size();
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            String s = input.get(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        System.out.println("n = " + n);
        System.out.println("startX = " + startX);
        System.out.println("startY = " + startY);

        boolean anyOnX = false, anyOnY = false;
        for (int i = 0; i < n; i++) anyOnY |= input.get(i).charAt(startY) == '#';
        for (int i = 0; i < n; i++) anyOnX |= input.get(startX).charAt(i) == '#';
        System.out.println(anyOnX);
        System.out.println(anyOnY);
    }

    private static List<String> parseInput(Scanner scanner) {
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) input.add(s);
        }
        return input;
    }

    private static long solve(List<String> input) {
        boolean[][] arr = new boolean[N][N];
        long ans = 0;

        copy(input, arr, 1, 1);
        ans += solveForQuarter(arr);

        copy(input, arr, 1, -1);
        ans += solveForQuarter(arr);

        copy(input, arr, -1, 1);
        ans += solveForQuarter(arr);

        copy(input, arr, -1, -1);
        ans += solveForQuarter(arr);

        ans -= 4 * ((STEPS + 1) / 2);

        return ans;
    }

    private static void copy(List<String> input, boolean[][] arr, int di, int dj) {
        for (int i1 = 0, i2 = n + 1; i1 < N; i1++) {
            for (int j1 = 0, j2 = n + 1; j1 < N; j1++) {
                arr[i1][j1] = input.get(i2).charAt(j2) == '#';
                j2 += dj;
                if (j2 == -1) j2 = N - 1;
                if (j2 == N) j2 = 0;
            }
            i2 += di;
            if (i2 == -1) i2 = N - 1;
            if (i2 == N) i2 = 0;
        }
    }

    @SuppressWarnings("ConstantValue")
    private static long solveForQuarter(boolean[][] mat) {
        int[][] distancesFromStart = calculateDistances(mat);
        int maxDistance = 0;
        for (int[] row : distancesFromStart) for (int val : row) if (val != MAX_VALUE) maxDistance = max(maxDistance, val);

        int[] accCountForDistances = new int[maxDistance + 1];
        for (int[] row : distancesFromStart) for (int val : row) if (val != MAX_VALUE) accCountForDistances[val]++;
        for (int i = 2; i <= maxDistance; i++) accCountForDistances[i] += accCountForDistances[i - 2];

        long fullyInEvenTimes = (STEPS + 2) / (2 * N);
        long fullyInEven = fullyInEvenTimes * fullyInEvenTimes * accCountForDistances[(maxDistance - 1) | 1];

        long fullyInOddTimes = (STEPS + 2 - N) / (2 * N);
        long fullyInOdd = fullyInOddTimes * (fullyInOddTimes + 1) * accCountForDistances[maxDistance & ~1];

        long partlyInEvenTimes = STEPS % (2 * N) == 2 * N - 2 || STEPS % (2 * N) == 2 * N - 1 ? 0 : (STEPS + 2 * N) / (2 * N);
        long partlyInEven = partlyInEvenTimes * partlyInEvenTimes * accCountForDistances[STEPS % (2 * N)];

        long partlyInOddTimes = STEPS % (2 * N) == N - 1 || STEPS % (2 * N) == N - 2 ? 0 : (STEPS + N) / (2 * N);
        long partlyInOdd = partlyInOddTimes * (partlyInOddTimes + 1) * accCountForDistances[(STEPS + N) % (2 * N)];

        return fullyInEven + fullyInOdd + partlyInEven + partlyInOdd;
    }

    private static int[][] calculateDistances(boolean[][] mat) {
        int[][] distanceFromStart = new int[N][N];
        ArrayTools.deepFill(distanceFromStart, MAX_VALUE);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        distanceFromStart[0][0] = 0;

        int generation = 0;
        while (!deque.isEmpty()) {
            generation++;
            int generationSize = deque.size();
            while (generationSize-- != 0) {
                int[] poll = deque.pollFirst();
                int x0 = poll[0], y0 = poll[1];
                for (int k = 0; k < 4; k++) {
                    int x1 = x0 + moves[k], y1 = y0 + moves[k + 1];
                    if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= N || distanceFromStart[x1][y1] != MAX_VALUE || mat[x1][y1]) continue;
                    distanceFromStart[x1][y1] = generation;
                    deque.offer(new int[]{x1, y1});
                }
            }
        }
        return distanceFromStart;
    }
}
