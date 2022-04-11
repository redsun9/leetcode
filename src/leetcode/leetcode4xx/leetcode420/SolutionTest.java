package leetcode.leetcode4xx.leetcode420;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    public static Stream<Arguments> getTestCases() {
        return Stream.of(
                Arguments.of("a", 5),
                Arguments.of("aA1", 3),
                Arguments.of("1337C0d3", 0),
                Arguments.of("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", 16),
                Arguments.of("bbaaaaaaaaaaaaaaacccccc", 8)
        );
    }

    @ParameterizedTest(name = "For password \"{0}\" ans should be {1}")
    @MethodSource("getTestCases")
    @DisplayName("Test some values")
    void testValues(String s, int expected) {
        assertEquals(expected, new Solution().strongPasswordChecker(s));
    }
}