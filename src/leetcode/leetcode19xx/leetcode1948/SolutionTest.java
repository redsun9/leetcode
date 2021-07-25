package leetcode.leetcode19xx.leetcode1948;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<List<String>> paths = List.of(List.of("a"), List.of("c"), List.of("d"), List.of("a", "b"), List.of("c", "b"), List.of("d", "a"));
        List<List<String>> expected = List.of(List.of("d"), List.of("d", "a"));
        List<List<String>> actual = new Solution().deleteDuplicateFolder(paths);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test2() {
        List<List<String>> paths = List.of(List.of("a"), List.of("c"), List.of("a", "b"), List.of("c", "b"), List.of("a", "b", "x"), List.of("a", "b", "x", "y"), List.of("w"), List.of("w", "y"));
        List<List<String>> expected = List.of(List.of("c"), List.of("c", "b"), List.of("a"), List.of("a", "b"));
        List<List<String>> actual = new Solution().deleteDuplicateFolder(paths);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test3() {
        List<List<String>> paths = List.of(List.of("a", "b"), List.of("c", "d"), List.of("c"), List.of("a"));
        List<List<String>> expected = List.of(List.of("c"), List.of("c", "d"), List.of("a"), List.of("a", "b"));
        List<List<String>> actual = new Solution().deleteDuplicateFolder(paths);
        assertEquals(expected.size(), actual.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}