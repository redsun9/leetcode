package leetcode.leetcode2xx.leetcode216;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testCorrectness() {
        for (int i = 1; i <= 60; i++) {
            for (int k = 2; k <= 9; k++) {
                assertEquals(
                        new Solution().combinationSum3(k, i).stream().map(HashSet::new).collect(Collectors.toSet()),
                        new Solution2().combinationSum3(k, i).stream().map(HashSet::new).collect(Collectors.toSet())
                );
            }
        }
    }
}