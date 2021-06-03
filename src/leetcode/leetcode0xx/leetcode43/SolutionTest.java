package leetcode.leetcode0xx.leetcode43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("6", new Solution().multiply("2", "3"));
    }

    @Test
    void test2() {
        assertEquals("56088", new Solution().multiply("123", "456"));
    }

    @Test
    void test3() {
        assertEquals(
                "2506975833036462966228095653142976230873207797749461630777267",
                new Solution().multiply(
                        "81274371238912983812312130912839029",
                        "30845834853240420934892423"
                )
        );
    }
}