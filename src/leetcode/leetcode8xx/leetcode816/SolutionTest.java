package leetcode.leetcode8xx.leetcode816;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "(123)";
        List<String> expected = List.of("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)");
        List<String> actual = new Solution().ambiguousCoordinates(s);
        List<String> l1 = expected.stream().sorted().collect(Collectors.toList());
        List<String> l2 = actual.stream().sorted().collect(Collectors.toList());
        assertEquals(l1, l2);
    }

    @Test
    void test2() {
        String s = "(00011)";
        List<String> expected = List.of("(0.001, 1)", "(0, 0.011)");
        List<String> actual = new Solution().ambiguousCoordinates(s);
        List<String> l1 = expected.stream().sorted().collect(Collectors.toList());
        List<String> l2 = actual.stream().sorted().collect(Collectors.toList());
        assertEquals(l1, l2);
    }

    @Test
    void test3() {
        String s = "(0123)";
        List<String> expected = List.of("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)");
        List<String> actual = new Solution().ambiguousCoordinates(s);
        List<String> l1 = expected.stream().sorted().collect(Collectors.toList());
        List<String> l2 = actual.stream().sorted().collect(Collectors.toList());
        assertEquals(l1, l2);
    }

    @Test
    void test4() {
        String s = "(100)";
        List<String> expected = List.of("(10, 0)");
        List<String> actual = new Solution().ambiguousCoordinates(s);
        List<String> l1 = expected.stream().sorted().collect(Collectors.toList());
        List<String> l2 = actual.stream().sorted().collect(Collectors.toList());
        assertEquals(l1, l2);
    }
}