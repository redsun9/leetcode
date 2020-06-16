package leetcode.leetcode3xx.leetcode310;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        assertEquals(
                Set.of(3,4),
                new HashSet<>(new Solution().findMinHeightTrees(6,edges))
        );
    }
}
