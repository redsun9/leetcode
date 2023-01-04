package basic.matrix;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatrixToolsTest {

    @Test
    void testCorrectness() {
        Random random = new Random(0L);
        int n = 403;
        long[][] a = new long[n][n];
        long[][] b = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(MatrixTools.p);
                b[i][j] = random.nextInt(MatrixTools.p);
            }
        }

        long[][] expected = MatrixTools.multiplyMatrix(a, b);
        long[][] actual1 = MatrixTools.multiStrassen(a, b);
        long[][] actual2 = MatrixTools.multiStrassenParallel(a, b);

        assertTrue(Objects.deepEquals(expected, actual1));
        assertTrue(Objects.deepEquals(expected, actual2));
    }

    //    threshold - ms
    //           n = 100
    //        15_272_299
    //        12_895_200
    //
    //           n = 200
    //        33_558_600
    //        37_820_401
    //
    //           n = 400
    //       222_920_501
    //       195_909_699
    //
    //           n = 800
    //     1_171_563_899
    //     2_504_104_201
    //
    //          n = 1600
    //     7_712_719_799
    //    28_701_119_700
    //
    //          n = 3200
    //    52_345_357_699
    //     4_868_970_700
    //   331_981_933_501
    //
    //          n = 6400
    //   363_590_418_300
    //    29_711_621_700
    // 2_685_464_068_200
    @Test
    @Disabled
    void testPerfStrassen() throws InterruptedException {
        Random random = new Random(0L);
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};
        long startTime, endTime;
        for (int n : sizes) {
            long[][] a = new long[n][n];
            long[][] b = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = random.nextInt(MatrixTools.p);
                    b[i][j] = random.nextInt(MatrixTools.p);
                }
            }
            System.out.println();
            System.out.println("n = " + n);

            startTime = System.nanoTime();
            MatrixTools.multiStrassen(a, b);
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
            System.gc();
            Thread.sleep(2000);

            startTime = System.nanoTime();
            MatrixTools.multiStrassenParallel(a, b);
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
            System.gc();
            Thread.sleep(2000);

            startTime = System.nanoTime();
            MatrixTools.multiplyMatrix(a, b);
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
            System.gc();
            Thread.sleep(2000);
        }
    }

    @Test
    void solve() {
        int[][] x = {{1, 2}, {2, 1}};
        int[] y = {3, 10};
        int[] actual = MatrixTools.solve(x, y, 31);
        int[] expected = {16, 9};
        assertArrayEquals(expected, actual);
    }
}