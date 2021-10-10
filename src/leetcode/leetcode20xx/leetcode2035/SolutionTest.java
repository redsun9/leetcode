package leetcode.leetcode20xx.leetcode2035;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    @Test
    void test1() {
        int[] nums = {3, 9, 7, 3};
        assertEquals(2, new Solution().minimumDifference(nums));
        assertEquals(2, new Solution2().minimumDifference(nums));
        assertEquals(2, new Solution3().minimumDifference(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        assertEquals(0, new Solution().minimumDifference(nums));
        assertEquals(0, new Solution2().minimumDifference(nums));
        assertEquals(0, new Solution3().minimumDifference(nums));
    }

    @Test
    void test3() {
        int[] nums = {0, 6, 11, 17, 18, 24};
        assertEquals(6, new Solution().minimumDifference(nums));
        assertEquals(6, new Solution2().minimumDifference(nums));
        assertEquals(6, new Solution3().minimumDifference(nums));
    }

    @Test
    void testCorrectness() {
        int n = 10, numberOfTests = 1_000;
        int min = -1_000_000, max = 1_000_000;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Random random = new Random(0);
        int[][] tests = new int[numberOfTests][n];
        for (int[] nums : tests) for (int i = 0; i < n; i++) nums[i] = min + random.nextInt(max - min + 1);
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            int a = solution.minimumDifference(tests[t]);
            int b = solution2.minimumDifference(tests[t]);
            int c = solution3.minimumDifference(tests[t]);
            assertEquals(a, b);
            assertEquals(a, c);
        });
    }
}