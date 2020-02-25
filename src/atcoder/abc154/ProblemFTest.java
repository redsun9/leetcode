package atcoder.abc154;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemFTest {

    @Test
    void manyManyPaths() {
        assertEquals(14, ProblemF.manyManyPaths(1, 1, 2, 2));
        assertEquals(602215194, ProblemF.manyManyPaths(314, 159, 2653, 589));

    }
}