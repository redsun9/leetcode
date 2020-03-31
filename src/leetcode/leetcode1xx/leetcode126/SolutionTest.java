package leetcode.leetcode1xx.leetcode126;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findLadders() {
        Solution solution = new Solution();
        assertEquals(
                new HashSet<>(Arrays.asList(
                        Arrays.asList("hit", "hot", "dot", "dog", "cog"),
                        Arrays.asList("hit", "hot", "lot", "log", "cog")
                )),
                new HashSet<>(
                        solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))
                )
        );
    }
}