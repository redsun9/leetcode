package binsearch.binsearch656;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] genes = {"ACGT", "ACCT", "AGGT", "TTTT", "TTTG"};
        assertEquals(2, new Solution().solve(genes));
    }

    @Test
    void test2() {
        String[] genes = {"CG"};
        assertEquals(1, new Solution().solve(genes));
    }

    @Test
    void test3() {
        String[] genes = {"AGC", "TGA", "TTC"};
        assertEquals(3, new Solution().solve(genes));
    }
}