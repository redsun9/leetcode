package leetcode.leetcode3xx.leetcode336;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String[] words = {"abcd", "dcba", "eef", "f", "fffee"};
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4));
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().palindromePairs(words)));
    }

    @Test
    void test2() {
        String[] words = {"a", "ab", "ba", "abab"};
        List<List<Integer>> expected = List.of(List.of(1, 0), List.of(1, 2), List.of(2, 1), List.of(0, 2), List.of(3, 0));
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().palindromePairs(words)));
    }
}