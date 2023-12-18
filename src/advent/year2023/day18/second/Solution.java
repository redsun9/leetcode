package advent.year2023.day18.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day18/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day18/second/output.txt");
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
            switch (split[2].charAt(7)) {
                case '0' -> moves[1] = 1;
                case '1' -> moves[0] = 1;
                case '2' -> moves[1] = -1;
                case '3' -> moves[0] = -1;
                default -> throw new RuntimeException();
            }
            moves[2] = parseInt(split[2].substring(2, 7), 16);
            arr[i] = moves;
        }
        return arr;
    }

    private static long solve(int[][] input) {
        Set<Long> pointsSetI = new HashSet<>();
        Set<Long> pointsSetJ = new HashSet<>();
        pointsSetI.add(0L);
        pointsSetJ.add(0L);

        long minI = 0, maxI = 0, minJ = 0, maxJ = 0;
        long currI = 0, currJ = 0;
        for (int[] move : input) {
            currI += (long) move[0] * move[2];
            currJ += (long) move[1] * move[2];
            minI = min(minI, currI);
            minJ = min(minJ, currJ);
            maxI = max(maxI, currI);
            maxJ = max(maxJ, currJ);
            pointsSetI.add(currI);
            pointsSetJ.add(currJ);
        }

        List<long[]> rangesI = toRanges(toSorted(pointsSetI));
        List<long[]> rangesJ = toRanges(toSorted(pointsSetJ));
        Map<Long, Integer> indicesI = getIndicesForPoints(pointsSetI, rangesI);
        Map<Long, Integer> indicesJ = getIndicesForPoints(pointsSetJ, rangesJ);

        int m = rangesI.size(), n = rangesJ.size();
        int[][] visited = new int[m][n];
        currI = 0;
        currJ = 0;
        int currIndexI = indicesI.get(currI);
        int currIndexJ = indicesJ.get(currJ);
        visited[currIndexI][currIndexJ] = 2;

        for (int[] move : input) {
            currI += (long) move[0] * move[2];
            currJ += (long) move[1] * move[2];
            int nextIndexI = indicesI.get(currI);
            int nextIndexJ = indicesJ.get(currJ);

            while (currIndexI != nextIndexI || currIndexJ != nextIndexJ) {
                currIndexI += move[0];
                currIndexJ += move[1];
                visited[currIndexI][currIndexJ] = 2;
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (visited[i][0] == 0) {
                visited[i][0] = 1;
                deque.offer(new int[]{i, 0});
            }
            if (visited[i][n - 1] == 0) {
                visited[i][n - 1] = 1;
                deque.offer(new int[]{i, n - 1});
            }
        }

        for (int j = 0; j < n; j++) {
            if (visited[0][j] == 0) {
                visited[0][j] = 1;
                deque.offer(new int[]{0, j});
            }
            if (visited[m - 1][j] == 0) {
                visited[m - 1][j] = 1;
                deque.offer(new int[]{m - 1, j});
            }
        }

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int i = poll[0], j = poll[1];
            for (int k = 0; k < 4; k++) {
                int i1 = i + moves[k], j1 = j + moves[k + 1];
                if (i1 < 0 || j1 < 0 || i1 >= m || j1 >= n || visited[i1][j1] != 0) continue;
                visited[i1][j1] = 1;
                deque.offer(new int[]{i1, j1});
            }
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1) ans += rangesI.get(i)[2] * rangesJ.get(j)[2];
            }
        }
        return ans;
    }

    private static long[] toSorted(Set<Long> set) {
        long[] arr = new long[set.size()];
        int pos = 0;
        for (Long val : set) arr[pos++] = val;
        Arrays.sort(arr);
        return arr;
    }

    private static List<long[]> toRanges(long[] arr) {
        List<long[]> list = new ArrayList<>();
        list.add(new long[]{arr[0], arr[0], 1});
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 != arr[i]) list.add(new long[]{arr[i - 1] + 1, arr[i] - 1, arr[i] - arr[i - 1] - 1});
            list.add(new long[]{arr[i], arr[i], 1});
        }
        return list;
    }

    private static Map<Long, Integer> getIndicesForPoints(Set<Long> points, List<long[]> list) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            long[] range = list.get(i);
            if (range[0] == range[1] && points.contains(range[0])) map.put(range[0], i);
        }
        return map;
    }
}