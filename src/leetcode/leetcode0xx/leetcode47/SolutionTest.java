package leetcode.leetcode0xx.leetcode47;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        List<List<Integer>> actual1 = solution.permuteUnique(new int[]{1, 1, 1, 2, 2});
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 1, 2, 2), List.of(1, 1, 2, 1, 2), List.of(1, 1, 2, 2, 1),
                List.of(1, 2, 1, 1, 2), List.of(1, 2, 1, 2, 1), List.of(1, 2, 2, 1, 1),
                List.of(2, 1, 1, 1, 2), List.of(2, 1, 1, 2, 1), List.of(2, 1, 2, 1, 1),
                List.of(2, 2, 1, 1, 1)
        );
        List<List<Integer>> actual2 = solution2.permuteUnique(new int[]{1, 1, 1, 2, 2});
        assertEquals(new HashSet<>(expected), new HashSet<>(actual1));
        assertEquals(new HashSet<>(expected), new HashSet<>(actual2));
    }


    @Test
    void test2() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        List<List<Integer>> actual1 = solution.permuteUnique(new int[]{1, 2, 3});
        List<List<Integer>> expected = List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        List<List<Integer>> actual2 = solution2.permuteUnique(new int[]{1, 2, 3});
        assertEquals(new HashSet<>(expected), new HashSet<>(actual1));
        assertEquals(new HashSet<>(expected), new HashSet<>(actual2));
    }

    @Test
    void testRandom() throws InterruptedException {
        int n = 8;
        int maxValue = 10;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        StressTester.exactStressTest(
                seed -> IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, maxValue + 1)).limit(n).toArray(),
                nums -> new HashSet<>(solution.permuteUnique(nums)),
                nums -> new HashSet<>(solution2.permuteUnique(nums)),
                1_000_000,
                10,
                1_000
        );
    }
}