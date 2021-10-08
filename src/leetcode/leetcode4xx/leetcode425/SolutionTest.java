package leetcode.leetcode4xx.leetcode425;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        List<List<String>> expected = List.of(
                List.of("wall", "area", "lead", "lady"),
                List.of("ball", "area", "lead", "lady")
        );
        List<List<String>> actual = new Solution().wordSquares(words);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test2() {
        String[] words = {"abat", "baba", "atan", "atal"};
        List<List<String>> expected = List.of(
                List.of("baba", "abat", "baba", "atan"),
                List.of("baba", "abat", "baba", "atal")
        );
        List<List<String>> actual = new Solution().wordSquares(words);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}