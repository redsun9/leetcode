package atcoder.agc047;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemBTest {

    @Test
    void test1() {
        char[][] strings = {"abcxyx".toCharArray(), "cyx".toCharArray(), "abc".toCharArray()};
        assertEquals(1, ProblemB.solve(strings));
    }

    @Test
    void test2() {
        char[][] strings = {
                "b".toCharArray(), "a".toCharArray(),
                "abc".toCharArray(), "c".toCharArray(),
                "d".toCharArray(), "ab".toCharArray()
        };
        assertEquals(5, ProblemB.solve(strings));
    }
}