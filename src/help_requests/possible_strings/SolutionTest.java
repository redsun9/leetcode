package help_requests.possible_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, Solution.numberOfPossibleStrings("AB"));
    }

    @Test
    void test2() {
        assertEquals(8L, Solution.numberOfPossibleStrings("AAB"));
    }

    @Test
    void test3() {
        assertEquals(64L, Solution.numberOfPossibleStrings("ABCD"));
    }
}