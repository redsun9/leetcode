package atcoder.abc156;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemETest {

    @Test
    void roaming() {
        assertEquals(10, ProblemE.roaming(3, 2));
        assertEquals(607923868, ProblemE.roaming(200000, 1000000000));
    }
}