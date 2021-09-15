package leetcode.leetcode2xx.leetcode202;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    // 83_656_335_700
    //  8_727_030_900
    //  2_070_066_000
    @Test
    @Disabled
    void testPerfMultiThread() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        int minN = 1;
        int maxN = Integer.MAX_VALUE;

        long startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN).parallel()
                .forEach(solution::isHappy);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN).parallel()
                .forEach(solution2::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN).parallel()
                .forEach(solution3::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    //  8268_091_500
    //  3542_371_200
    //   700_690_000
    @Test
    @Disabled
    void testPerfSingleThread() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        int minN = 1 << 25;
        int maxN = 1 << 26;

        long startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN)
                .forEach(solution::isHappy);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN)
                .forEach(solution2::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(minN, maxN)
                .forEach(solution3::isHappy);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }


    @Test
    @Disabled
    void testCorrectness() {
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        IntStream.rangeClosed(1, Integer.MAX_VALUE).parallel()
                .forEach(n -> assertEquals(solution2.isHappy(n), solution3.isHappy(n)));
    }
}