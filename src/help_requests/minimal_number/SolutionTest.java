package help_requests.minimal_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minimalNumber() {
        assertEquals("10", Solution.minimalNumber("10"));
        assertEquals("123", Solution.minimalNumber("321"));
        assertEquals("10023", Solution.minimalNumber("32100"));
        assertEquals("203499", Solution.minimalNumber("324990"));
        assertEquals("809", Solution.minimalNumber("980"));
    }
}