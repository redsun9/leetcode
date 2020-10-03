package leetcode.leetcode3xx.leetcode373;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void perfTest() {
        // on large test inputs secodn solution 6 times faster
        Random random = new Random();
        int numberOfTests = 1000;
        int testLength = 1000;
        int maxA = 1_000_000_000;
        int k = 10_000;
        int[][] a = new int[numberOfTests][testLength];
        int[][] b = new int[numberOfTests][testLength];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < testLength; j++) {
                a[i][j] = random.nextInt(maxA);
                b[i][j] = random.nextInt(maxA);
            }
            Arrays.sort(a[i]);
            Arrays.sort(b[i]);
        }
        Solution first = new Solution();
        Solution2 second = new Solution2();

        long start = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i ->
                assertEquals(k, first.kSmallestPairs(a[i], b[i], k).size())
        );
        long end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i ->
                assertEquals(k, second.kSmallestPairs(a[i], b[i], k).size())
        );
        end = System.nanoTime();
        System.out.println(end - start);
    }
}