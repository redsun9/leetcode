package advent.year2023.day23.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};
    private static final Map<Character, Integer> slopesMap = Map.of(
            'v', 0,
            '<', 1,
            '^', 2,
            '>', 3
    );

    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day1/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day23/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day23/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> input = parseInput(scanner);
//            checkInput(input);
            printer.println(solve(input));
        }
    }

    private static List<String> parseInput(Scanner scanner) {
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) input.add(s);
        }
        return input;
    }

    // there is only 34 crossroads, and there is no crossroads with slopes
    private static void checkInput(List<String> input) {
        int numberOfCrossroads = 0;
        int m = input.size(), n = input.get(0).length();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (input.get(i).charAt(j) == '#') continue;
                int numberOfDots = 0;
                for (int k = 0; k < 4; k++) if (input.get(i + moves[k]).charAt(j + moves[k + 1]) != '#') numberOfDots++;
                if (numberOfDots >= 3) numberOfCrossroads++;
            }
        }
        System.out.println("Crossroads = " + numberOfCrossroads);

        int crossRoadsWithSlopes = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (input.get(i).charAt(j) == '#' || input.get(i).charAt(j) == '.') continue;
                int numberOfDots = 0;
                for (int k = 0; k < 4; k++) if (input.get(i + moves[k]).charAt(j + moves[k + 1]) != '#') numberOfDots++;
                if (numberOfDots >= 3) crossRoadsWithSlopes++;
            }
        }
        System.out.println("CrossRoadsWithSlopes = " + crossRoadsWithSlopes);
    }

    private static int solve(List<String> input) {
        int m = input.size(), n = input.get(0).length();
        Map<Point, Integer> pointsIdxMap = new HashMap<>();
        List<Point> points = new ArrayList<>();

        pointsIdxMap.put(new Point(0, 1), 0);
        points.add(new Point(0, 1));

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (input.get(i).charAt(j) == '#') continue;
                int numberOfDots = 0;
                for (int k = 0; k < 4; k++) if (input.get(i + moves[k]).charAt(j + moves[k + 1]) != '#') numberOfDots++;
                if (numberOfDots >= 3) {
                    Point point = new Point(i, j);
                    pointsIdxMap.put(point, points.size());
                    points.add(point);
                }
            }
        }
        pointsIdxMap.put(new Point(m - 1, n - 2), points.size());
        points.add(new Point(m - 1, n - 2));

        int numberOfPoints = points.size();
        List<Edge>[] adj = new List[numberOfPoints];
        for (int fromIdx = 0; fromIdx < numberOfPoints; fromIdx++) {
            adj[fromIdx] = new ArrayList<>();
            Point from = points.get(fromIdx);
            int i0 = from.i, j0 = from.j;
            for (int k = 0; k < 4; k++) {
                int i1 = i0 + moves[k], j1 = moves[k + 1];
                if (i1 < 0 || j1 < 0 || i1 >= m || j1 >= n || input.get(i1).charAt(j1) == '#') continue;
                Edge road = findRoad(from, fromIdx, i1, j1, input, pointsIdxMap);
                if (road != null) adj[fromIdx].add(road);
            }
        }


        return 0;
    }

    private static Edge findRoad(Point from, int fromIdx, int firstStepI, int firstStepJ, List<String> input, Map<Point, Integer> pointsIdxMap) {
        int m = input.size(), n = input.get(0).length();
        int distance = 1;
        int i0 = from.i, j0 = from.j, i1 = firstStepI, j1 = firstStepJ;
        while (true) {
            if (i1 == from.i && j1 == from.j) return null;
            if (pointsIdxMap.containsKey(new Point(i1, j1))) {
                Integer toIdx = pointsIdxMap.get(new Point(i1, j1));
                return new Edge(fromIdx, toIdx, distance);
            }
            char c = input.get(i1).charAt(j1);
            if (slopesMap.containsKey(c)) {
                int k = slopesMap.get(c);
                int i2 = i1 + moves[k], j2 = j1 + moves[k + 1];
                if (i2 == i0 && j2 == j0) return null;
                i0 = i1;
                j0 = j1;
                i1 = i2;
                j1 = j2;
                distance++;
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int i2 = i1 + moves[k], j2 = j1 + moves[k + 1];
                if (i2 < 0 || j2 < 0 || i2 >= m || j2 >= n || input.get(i2).charAt(j2) == '#') continue;
                if (i2 == i0 && j2 == j0) continue;
                i0 = i1;
                j0 = j1;
                i1 = i2;
                j1 = j2;
                distance++;
            }
        }
    }


    private record Point(int i, int j) {
    }

    private record Edge(int u, int v, int d) {
    }
}
