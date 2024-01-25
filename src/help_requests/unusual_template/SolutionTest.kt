package help_requests.unusual_template

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun test() {
        assertTrue(Solution.solve3("a", "a", "b", "b"))
        assertFalse(Solution.solve3("a", "a", "b", "c"))
        assertFalse(Solution.solve3("a", "a", "a", "b"))
        assertFalse(Solution.solve3("a", "a", "a", "a"))
        assertTrue(Solution.solve3("aa", "aa", "ab", "ba"))
        assertTrue(Solution.solve3("aa", "aa", "bb", "cc"))
        assertTrue(Solution.solve3("aa", "aa", "ab", "bb"))
        assertTrue(Solution.solve3("aa", "aa", "ab", "bc"))
        assertTrue(Solution.solve3("aa", "aa", "bc", "cd"))
    }
}