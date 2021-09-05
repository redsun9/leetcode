package leetcode.leetcode0xx.leetcode90;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expected = List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2));
        List<List<Integer>> actual = new Solution2().subsetsWithDup(nums);

        assertEquals(
                expected.stream().map(x -> x.stream().sorted().collect(Collectors.toList())).collect(Collectors.toSet()),
                actual.stream().map(x -> x.stream().sorted().collect(Collectors.toList())).collect(Collectors.toSet())
        );
    }


    @Test
    void test2() {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        List<List<Integer>> expected = new Solution().subsetsWithDup(nums);
        List<List<Integer>> actual = new Solution2().subsetsWithDup(nums);

        assertEquals(
                expected.stream().map(x -> x.stream().sorted().collect(Collectors.toList())).collect(Collectors.toSet()),
                actual.stream().map(x -> x.stream().sorted().collect(Collectors.toList())).collect(Collectors.toSet())
        );
    }
}