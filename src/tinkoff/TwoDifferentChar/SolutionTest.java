package tinkoff.TwoDifferentChar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(Solution.solve("ABBA".toCharArray()));
    }

    @Test
    void test2() {
        assertTrue(Solution.solve("GOGO".toCharArray()));
    }

    @Test
    void test3() {
        assertFalse(Solution.solve("FIRE".toCharArray()));
    }

    @Test
    void test4() {
        assertFalse(Solution.solve("WAPP".toCharArray()));
    }

    @Test
    void test5() {
        assertFalse(Solution.solve("AAAA".toCharArray()));
    }

    @Test
    void test6() {
        assertFalse(Solution.solve("BAAA".toCharArray()));
    }
}