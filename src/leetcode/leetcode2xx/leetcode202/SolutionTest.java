package leetcode.leetcode2xx.leetcode202;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class SolutionTest {
    // 96825360400
    //  8541880300
    @Test
    @Disabled
    void testPerfMultiThread() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        long startTime = System.nanoTime();
        IntStream.rangeClosed(1, Integer.MAX_VALUE).parallel()
                .forEach(solution::isHappy);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(1, Integer.MAX_VALUE).parallel()
                .forEach(solution2::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    //  221234949800
    //  134618382700
    @Test
    @Disabled
    void testPerfSingleThread() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        long startTime = System.nanoTime();
        IntStream.rangeClosed(1 << 30, Integer.MAX_VALUE)
                .forEach(solution::isHappy);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(1 << 30, Integer.MAX_VALUE)
                .forEach(solution2::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}