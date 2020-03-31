package leetcode.leetcode1xx.leetcode140;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void wordBreak() {
        Solution solution = new Solution();
        assertEquals(
                new HashSet<>(Arrays.asList(
                        "cats and dog", "cat sand dog"
                )),
                new HashSet<>(solution.wordBreak(
                        "catsanddog",
                        Arrays.asList("cat", "cats", "and", "sand", "dog")
                ))
        );
        assertEquals(
                new HashSet<>(Arrays.asList(
                        "pine apple pen apple",
                        "pineapple pen apple",
                        "pine applepen apple"
                )),
                new HashSet<>(solution.wordBreak(
                        "pineapplepenapple",
                        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")
                ))
        );
        assertEquals(
                Collections.emptySet(),
                new HashSet<>(solution.wordBreak(
                        "catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")
                ))
        );
        solution.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        );
    }
}