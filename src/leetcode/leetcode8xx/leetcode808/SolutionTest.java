package leetcode.leetcode8xx.leetcode808;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        IntStream.range(0, 250).parallel().forEach(i ->
                Assertions.assertEquals(solution.soupServings(i * 25), solution2.soupServings(i * 25), 1e-6)
        );
    }
}