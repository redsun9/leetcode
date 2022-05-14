package leetcode.leetcode22xx.leetcode2272;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {
    private static final int ALPHABET_SIZE = 26;

    @Test
    void test1() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String s = "aababbb";
        assertEquals(3, solution.largestVariance(s));
        assertEquals(3, solution2.largestVariance(s));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String s = "abcde";
        assertEquals(0, solution.largestVariance(s));
        assertEquals(0, solution2.largestVariance(s));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String s = "eruaareuaa";
        assertEquals(3, solution.largestVariance(s));
        assertEquals(3, solution2.largestVariance(s));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String s = "bccbc";
        assertEquals(2, solution.largestVariance(s));
        assertEquals(2, solution2.largestVariance(s));
    }

    @Test
    void testCorrectness() throws InterruptedException {
        int n = 20;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        StressTester.exactStressTest(
                seed -> {
                    Random r = new Random(seed);
                    char[] chars = new char[n];
                    for (int i = 0; i < n; i++) chars[i] = (char) ('a' + r.nextInt(5));
                    return new String(chars);
                },
                solution::largestVariance,
                solution2::largestVariance,
                1_000_000_000,
                1,
                100_000
        );
    }
}