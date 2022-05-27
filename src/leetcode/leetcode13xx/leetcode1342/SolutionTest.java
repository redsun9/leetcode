package leetcode.leetcode13xx.leetcode1342;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        for (int i = 0; i <= 1_000_000; i++) {
            assertEquals(solution.numberOfSteps(i), solution2.numberOfSteps(i));
        }
    }
}