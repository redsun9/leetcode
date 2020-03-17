package leetcode.leetcode212;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void findWords() {
        Solution solution = new Solution();
        assertEquals(
                new HashSet<>(Arrays.asList("eat", "oath")),
                new HashSet<>(
                        solution.findWords(
                                new char[][]{
                                        {'o', 'a', 'a', 'n'},
                                        {'e', 't', 'a', 'e'},
                                        {'i', 'h', 'k', 'r'},
                                        {'i', 'f', 'l', 'v'}
                                },
                                new String[]{"oath", "pea", "eat", "rain"}
                        )
                )
        );
        assertEquals(
                new HashSet<>(Arrays.asList("a")),
                new HashSet<>(
                        solution.findWords(
                                new char[][]{
                                        {'a'}
                                },
                                new String[]{"a"}
                        )
                )
        );

    }
}