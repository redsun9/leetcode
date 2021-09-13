package leetcode.leetcode0xx.leetcode47;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void permuteUnique() {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 1, 1, 2, 2});
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 1, 2, 2), List.of(1, 1, 2, 1, 2), List.of(1, 1, 2, 2, 1),
                List.of(1, 2, 1, 1, 2), List.of(1, 2, 1, 2, 1), List.of(1, 2, 2, 1, 1),
                List.of(2, 1, 1, 1, 2), List.of(2, 1, 1, 2, 1), List.of(2, 1, 2, 1, 1),
                List.of(2, 2, 1, 1, 1)
        );
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}