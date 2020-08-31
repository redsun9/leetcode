package microsoft.binaryperiod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, new Solution().solution(955));
        assertEquals(5, new Solution().solution(924));
    }
}