package leetcode.leetcode4xx.leetcode472;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        assertEquals(
                Set.of("catsdogcats", "dogcatsdog", "ratcatdogcat"),
                new HashSet<>(new Solution().findAllConcatenatedWordsInADict(words))
        );
    }
}