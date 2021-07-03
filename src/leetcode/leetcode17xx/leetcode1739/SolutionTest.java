package leetcode.leetcode17xx.leetcode1739;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().minimumBoxes(3));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().minimumBoxes(4));
    }

    @Test
    void test3() {
        assertEquals(6, new Solution().minimumBoxes(10));
    }

    @Test
    @Disabled
    void testLee() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        AtomicInteger failed = new AtomicInteger(0);
        IntStream.rangeClosed(0, 1_000_000_000).parallel().forEach(n -> {
            try {
                assertEquals(solution.minimumBoxes(n), solution2.minimumBoxes(n));
            } catch (Throwable e) {
                failed.incrementAndGet();
            }
        });
        System.out.println("Failed - " + failed.get());
    }

    @Test
    @Disabled
    void testYe15() {
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        IntStream.rangeClosed(0, 2_000_000_000).parallel().forEach(n -> {
            try {
                assertEquals(solution.minimumBoxes(n), solution3.minimumBoxes(n));
            } catch (Throwable e) {
                System.out.println(n + " " + solution.minimumBoxes(n) + " " + solution3.minimumBoxes(n));
            }
        });
    }
}