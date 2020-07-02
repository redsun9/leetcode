package leetcode.leetcode9xx.leetcode963;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int maxCoord = 40000;

    @Test
    @org.junit.jupiter.api.Disabled
    void prefTest() {
//        8419151500
//        1745615600
//        1208062100
        int numberOfTests = 1000;
        int testLength = 100;
        int[][][] tests = prepareTests(numberOfTests, testLength);
        MinAreaRectFinder[] finders = {new Solution(), new Solution2(), new Solution3()};
        for (MinAreaRectFinder finder : finders) {
            long start = System.nanoTime();
            for (int[][] test : tests) {
                assertTrue(finder.minAreaFreeRect(test) >= 0);
            }
            long end = System.nanoTime();
            System.out.println(end - start);
        }
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void prefTest2() {
        //solution2 - 18250616900
        //solution3 - 2733845800
        int numberOfTests = 10;
        int testLength = 1000;
        int[][][] tests = prepareTests(numberOfTests, testLength);
        MinAreaRectFinder[] finders = {new Solution2(), new Solution3()};
        for (MinAreaRectFinder finder : finders) {
            long start = System.nanoTime();
            for (int[][] test : tests) {
                assertTrue(finder.minAreaFreeRect(test) >= 0);
            }
            long end = System.nanoTime();
            System.out.println(end - start);
        }
    }


    private static int[][][] prepareTests(int numberOfTests, int testLength) {
        Random random = new Random(0);
        int[][][] tests = new int[numberOfTests][testLength][2];
        for (int i = 0; i < numberOfTests; i++) {
            HashSet<Point> points = new HashSet<>();
            int j = 0;
            while (j < testLength) {
                Point point = new Point(random.nextInt(maxCoord + 1), random.nextInt(maxCoord + 1));
                if (points.add(point)) {
                    tests[i][j][0] = point.x;
                    tests[i][j][1] = point.y;
                    j++;
                }
            }
        }
        return tests;
    }

    private static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

