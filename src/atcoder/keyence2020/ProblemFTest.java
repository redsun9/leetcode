package atcoder.keyence2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemFTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void numberOfDrawings() {
        int actual = ProblemF.numberOfDrawings(new boolean[][]{{true, false}, {false, true}});
        assertEquals(15, actual);
    }
}