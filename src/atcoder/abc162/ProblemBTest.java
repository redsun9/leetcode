package atcoder.abc162;

import org.junit.jupiter.api.Test;

import static atcoder.abc162.ProblemB.f;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemBTest {

    @Test
    void test() {
        long a = 0;
        for (int i = 0; i < 10000; i++) {
            if (i % 3 != 0 && i % 5 != 0) a += i;
            assertEquals(a, f(i));
        }
    }
}