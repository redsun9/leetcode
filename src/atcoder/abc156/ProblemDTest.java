package atcoder.abc156;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemDTest {

    @Test
    void bouquet() {
        assertEquals(7, ProblemD.bouquet(4, 1, 3));
        assertEquals(34076506, ProblemD.bouquet(1000000000, 141421, 173205));
    }
}