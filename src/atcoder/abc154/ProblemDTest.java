package atcoder.abc154;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemDTest {

    @org.junit.jupiter.api.Test
    void maxMathExpectation() {
        assertEquals(7.0f, ProblemD.maxMathExpectation(new int[]{1, 2, 2, 4, 5}, 3));
        assertEquals(3.5f, ProblemD.maxMathExpectation(new int[]{6, 6, 6, 6}, 1));
        assertEquals(32.0f, ProblemD.maxMathExpectation(new int[]{17, 13, 13, 12, 15, 20, 10, 13, 17, 11}, 4));
    }
}