package leetcode.leetcode9xx.leetcode920;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 3, goal = 3, k = 1;
        assertEquals(6, new Solution().numMusicPlaylists(n, goal, k));
    }

    @Test
    void test2() {
        int n = 2, goal = 3, k = 0;
        assertEquals(6, new Solution().numMusicPlaylists(n, goal, k));
    }

    @Test
    void test3() {
        int n = 2, goal = 3, k = 1;
        assertEquals(2, new Solution().numMusicPlaylists(n, goal, k));
    }
}