package leetcode.leetcode1xx.leetcode131;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Set<List<String>> expected = Set.of(
                List.of("aa", "b"),
                List.of("a", "a", "b")
        );
        assertEquals(expected, new HashSet<>(new Solution().partition("aab")));
    }
}