package leetcode.leetcode0xx.leetcode78;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = new Solution2().subsets(nums);
        List<List<Integer>> expected = List.of(
                List.of(), List.of(1), List.of(2), List.of(1, 2),
                List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)
        );
        assertEquals(
                expected.stream().map(HashSet::new).collect(Collectors.toSet()),
                actual.stream().map(HashSet::new).collect(Collectors.toSet())
        );
    }
}