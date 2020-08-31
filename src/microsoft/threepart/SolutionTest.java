package microsoft.threepart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().solution("babaa"));
    }

    @Test
    void test2() {
        assertEquals(4, new Solution().solution("ababa"));
    }

    @Test
    void test3() {
        assertEquals(0, new Solution().solution("aba"));
    }

    @Test
    void test4() {
        assertEquals(6, new Solution().solution("bbbbb"));
    }
}