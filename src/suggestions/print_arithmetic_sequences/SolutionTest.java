package suggestions.print_arithmetic_sequences;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> expected = List.of();
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(0, actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> expected = List.of(List.of(1, 3, 5), List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4), List.of(2, 3, 4, 5), List.of(1, 2, 3), List.of(2, 3, 4), List.of(3, 4, 5));
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test3() {
        int[] nums = {7, 7, 7, 7};
        List<List<Integer>> expected = List.of(List.of(7, 7, 7), List.of(7, 7, 7, 7));
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test4() {
        int[] nums = {2, 3, 4, 5, 1, 2, 3, 4};
        List<List<Integer>> expected = List.of(List.of(2, 3, 4), List.of(2, 3, 4, 5), List.of(1, 2, 3, 4), List.of(1, 2, 3), List.of(3, 4, 5));
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test5() {
        int[] nums = {3, 4, 5, 6, 1, 2, 3, 4};
        List<List<Integer>> expected = List.of(List.of(3, 4, 5), List.of(4, 5, 6), List.of(3, 4, 5, 6), List.of(1, 2, 3), List.of(2, 3, 4), List.of(1, 2, 3, 4));
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }


    @Test
    void test6() {
        int[] nums = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        List<List<Integer>> expected = List.of(List.of(9, 8, 7), List.of(8, 7, 6), List.of(9, 8, 7, 6), List.of(7, 6, 5), List.of(8, 7, 6, 5), List.of(9, 8, 7, 6, 5), List.of(9, 7, 5), List.of(1, 2, 3), List.of(2, 3, 4), List.of(1, 2, 3, 4), List.of(3, 4, 5), List.of(2, 3, 4, 5), List.of(1, 2, 3, 4, 5), List.of(2, 4, 6), List.of(1, 3, 5));
        List<List<Integer>> actual = new Solution().findSubsequences(nums);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}