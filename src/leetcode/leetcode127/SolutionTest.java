package leetcode.leetcode127;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void ladderLength() {
        Solution solution = new Solution();
        assertEquals(
                5,
                solution.ladderLength(
                        "hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")
                )
        );
    }
}