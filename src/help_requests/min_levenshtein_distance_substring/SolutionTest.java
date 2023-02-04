package help_requests.min_levenshtein_distance_substring;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("abc", Solution.solve("abc", "abc"));
    }

    @Test
    void test2() {
        assertEquals("ab", Solution.solve("abc", "ab"));
    }

    @Test
    void test3() {
        assertEquals("abc", Solution.solve("abc", "abd"));
    }

    @Test
    void test4() {
        Set<String> expected = Set.of("abc", "ab");
        assertTrue(expected.contains(Solution.solve("abc", "abde")));
    }

    @Test
    void test5() {
        Set<String> expected = Set.of("abc", "ab");
        assertTrue(expected.contains(Solution.solve("abc", "abdef")));
    }

    @Test
    void test6() {
        assertEquals("abc", Solution.solve("abcdefgh", "dabc"));
    }

    @Test
    void test7() {
        assertEquals("efgh", Solution.solve("abcdefgh", "efghik"));
    }

    @Test
    void test8() {
        Set<String> expected = Set.of("ab", "abс", "abcd", "de", "cde", "bcde");
        assertTrue(expected.contains(Solution.solve("abcde", "abde")));
    }
}