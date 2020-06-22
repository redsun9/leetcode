package leetcode.leetcode14xx.leetcode1489;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
        List<List<Integer>> actual = new Solution().findCriticalAndPseudoCriticalEdges(5, edges);
        assertEquals(Set.of(0, 1), new HashSet<>(actual.get(0)));
        assertEquals(Set.of(2, 3, 4, 5), new HashSet<>(actual.get(1)));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}};
        List<List<Integer>> actual = new Solution().findCriticalAndPseudoCriticalEdges(4, edges);
        assertEquals(Collections.emptySet(), new HashSet<>(actual.get(0)));
        assertEquals(Set.of(0, 1, 2, 3), new HashSet<>(actual.get(1)));
    }


    @Test
    void test3() {
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {2, 3, 4}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}};
        List<List<Integer>> actual = new Solution().findCriticalAndPseudoCriticalEdges(6, edges);
        assertEquals(Collections.singleton(3), new HashSet<>(actual.get(0)));
        assertEquals(Set.of(0, 1, 2, 4, 5, 6), new HashSet<>(actual.get(1)));
    }

    @Test
    void test4() { //counterexample
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {3, 4, 1}, {3, 5, 1}, {4, 5, 1}, {1, 4, 1}};
        List<List<Integer>> actual = new Solution().findCriticalAndPseudoCriticalEdges(6, edges);
        assertEquals(Set.of(6), new HashSet<>(actual.get(0)));
        assertEquals(Set.of(0, 1, 2, 3, 4, 5), new HashSet<>(actual.get(1)));
    }
}