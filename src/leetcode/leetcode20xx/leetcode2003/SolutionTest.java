package leetcode.leetcode20xx.leetcode2003;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] parents = {-1, 0, 0, 2}, nums = {1, 2, 3, 4}, expected = {5, 1, 1, 1};
        assertArrayEquals(expected, new Solution().smallestMissingValueSubtree(parents, nums));
    }

    @Test
    void test2() {
        int[] parents = {-1, 0, 1, 0, 3, 3}, nums = {5, 4, 6, 2, 1, 3}, expected = {7, 1, 1, 4, 2, 1};
        assertArrayEquals(expected, new Solution().smallestMissingValueSubtree(parents, nums));
    }

    @Test
    void test3() {
        int[] parents = {-1, 2, 3, 0, 2, 4, 1}, nums = {2, 3, 4, 5, 6, 7, 8}, expected = {1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, new Solution().smallestMissingValueSubtree(parents, nums));
    }

    @Test
    void testRandom() {
        int n = 10_000;
        int numberOfTests = 1000;
        int[][][] tests = new int[numberOfTests][2][];

        Random random = new Random(0);
        for (int t = 0; t < numberOfTests; t++) {
            int[] parents = new int[n];
            parents[0] = -1;
            for (int i = 1; i < n; i++) parents[i] = random.nextInt(i);

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = i + 1;
            for (int i = n - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            tests[t][0] = parents;
            tests[t][1] = nums;
        }


        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        IntStream.range(0, numberOfTests).parallel().forEach(t ->
                assertArrayEquals(
                        solution.smallestMissingValueSubtree(tests[t][0], tests[t][1]),
                        solution2.smallestMissingValueSubtree(tests[t][0], tests[t][1])
                )
        );
    }
}