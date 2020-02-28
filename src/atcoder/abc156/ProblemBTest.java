package atcoder.abc156;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemBTest {
    @Test
    void numberOfDigitsInBase() {
        assertEquals(4, ProblemB.numberOfDigitsInBase(11, 2));
        assertEquals(7, ProblemB.numberOfDigitsInBase(1010101, 10));
        assertEquals(18, ProblemB.numberOfDigitsInBase(314159265, 3));
    }
}