package leetcode.leetcode9xx.leetcode926;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1,new Solution().minFlipsMonoIncr("00110"));
    }

    @Test
    void test2() {
        assertEquals(2,new Solution().minFlipsMonoIncr("010110"));
    }

    @Test
    void test3() {
        assertEquals(2,new Solution().minFlipsMonoIncr("00011000"));
    }
}
