package advent.year2023.day22.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("DuplicatedCode")
public class Solution {

    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/first/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day22/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<int[]> parseInput(Scanner scanner) {
        List<int[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) {
                String[] split = s.split("\\D+");
                int[] block = new int[6];
                for (int i = 0; i < 6; i++) block[i] = Integer.parseInt(split[i]);
                input.add(block);
            }
        }
        return input;
    }

    private static int solve(List<int[]> input) {
        int n = input.size();
        input.sort(comparingInt(x -> x[5]));

        boolean[] cantBeRemoved = new boolean[n + 1];

        int minX = MAX_VALUE, maxX = Integer.MIN_VALUE, minY = MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] block : input) {
            minX = Math.min(minX, block[0]);
            maxX = Math.max(maxX, block[3]);
            minY = Math.min(minY, block[1]);
            maxY = Math.max(maxY, block[4]);
        }

        QuadTree tree = new QuadTree(minX, maxX, minY, maxY, 0, 0);
        for (int i = 0; i < n; i++) {
            int[] block = input.get(i);
            TwoMaxResult twoMaxResult = tree.checkFalling(block[0], block[3], block[1], block[4]);
            if (twoMaxResult.h1 != twoMaxResult.h2) cantBeRemoved[twoMaxResult.idx1] = true;
            tree.placeBlock(block[0], block[3], block[1], block[4], twoMaxResult.h1 + block[5] - block[2] + 1, i + 1);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) if (!cantBeRemoved[i]) ans++;
        return ans;
    }


    private static class QuadTree {
        final int x1, x2, y1, y2;
        TwoMaxResult twoMaxResult;
        QuadTree[][] children;

        private QuadTree(int x1, int x2, int y1, int y2, int idx, int h) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.twoMaxResult = new TwoMaxResult(h, -1, idx, -1);
        }

        private TwoMaxResult checkFalling(int x1, int x2, int y1, int y2) {
            if (!intersects(x1, y1, x2, y2, this.x1, this.y1, this.x2, this.y2)) return TwoMaxResult.DEFAULT;
            if (overlaps(x1, y1, x2, y2, this.x1, this.y1, this.x2, this.y2) || children == null) return twoMaxResult;

            TwoMaxResult result = TwoMaxResult.DEFAULT;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (children[i][j] == null) continue;
                    TwoMaxResult childResult = children[i][j].checkFalling(x1, x2, y1, y2);
                    result = combine(result, childResult);
                }
            }
            return result;
        }

        private void placeBlock(int x1, int y1, int x2, int y2, int h, int idx) {
            if (!intersects(x1, y1, x2, y2, this.x1, this.y1, this.x2, this.y2)) return;
            if (overlaps(x1, y1, x2, y2, this.x1, this.y1, this.x2, this.y2)) {
                children = null;
                twoMaxResult = new TwoMaxResult(h, idx);
            } else {
                if (children == null) populate();
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        if (children[i][j] != null) children[i][j].placeBlock(x1, y1, x2, y2, h, idx);
                twoMaxResult = combine(twoMaxResult, new TwoMaxResult(h, idx));
            }
        }

        private void populate() {
            children = new QuadTree[2][2];
            int[] xs = {x1, (x1 + x2) / 2, (x1 + x2) / 2 + 1, x2};
            int[] ys = {y1, (y1 + y2) / 2, (y1 + y2) / 2 + 1, y2};
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (xs[i * 2] <= xs[i * 2 + 1] && ys[j * 2] <= ys[j * 2 + 1]) {
                        children[i][j] = new QuadTree(xs[i * 2], xs[i * 2 + 1], ys[j * 2], ys[j * 2 + 1], twoMaxResult.idx1, twoMaxResult.h1);
                    }
                }
            }
        }
    }

    private record TwoMaxResult(int h1, int h2, int idx1, int idx2) {
        private static final TwoMaxResult DEFAULT = new TwoMaxResult(0, -1, 0, -1);

        private TwoMaxResult(int h, int idx) {
            this(h, -1, idx, -1);
        }
    }

    private static TwoMaxResult combine(TwoMaxResult a, TwoMaxResult b) {
        if (a == TwoMaxResult.DEFAULT) return b;
        if (b == TwoMaxResult.DEFAULT) return a;
        int[][] c = {{a.h1, a.idx1}, {a.h2, a.idx2}, {b.h1, b.idx1}, {b.h2, b.idx2}};
        Arrays.sort(c, comparingInt((int[] x) -> -x[0]).thenComparingInt(x -> x[1]));
        if (c[0][1] != c[1][1]) return new TwoMaxResult(c[0][0], c[1][0], c[0][1], c[1][1]);
        else return new TwoMaxResult(c[0][0], c[2][0], c[0][1], c[2][1]);
    }

    private static boolean intersects(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return intersects(x1, x2, x3, x4) && intersects(y1, y2, y3, y4);
    }

    private static boolean overlaps(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return overlaps(x1, x2, x3, x4) && overlaps(y1, y2, y3, y4);
    }

    private static boolean intersects(int a1, int b1, int a2, int b2) {
        return max(a1, a2) <= min(b1, b2);
    }

    private static boolean overlaps(int a1, int b1, int a2, int b2) {
        return a1 <= a2 && b1 >= b2;
    }
}
