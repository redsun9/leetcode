package suggestions.number_arithmetic_sequences;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {4, 6, 7, 7};
        assertEquals(0, new Solution().findSubsequences(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(7, new Solution().findSubsequences(nums));
    }

    @Test
    void test3() {
        int[] nums = {7, 7, 7, 7};
        assertEquals(2, new Solution().findSubsequences(nums));
    }

    @Test
    void test4() {
        int[] nums = {2, 3, 4, 1, 2, 3};
        assertEquals(2, new Solution().findSubsequences(nums));
    }

    @Test
    void test5() {
        int[] nums = {2, 3, 4, 5, 1, 2, 3, 4};
        assertEquals(5, new Solution().findSubsequences(nums));
    }

    @Test
    @Disabled
    void test6() {
        IntStream.range(5, 1001).parallel().forEach(n -> {
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) nums[i] = i;
            int expected = 0;
            for (int d = 1; d <= n / 2; d++) {
                int m = n / d + 1;
                expected += (2 * (n + 1) - d * (m + 1)) * (m - 2);
            }
            expected /= 2;
            assertEquals(expected, new Solution().findSubsequences(nums));
        });
    }
}