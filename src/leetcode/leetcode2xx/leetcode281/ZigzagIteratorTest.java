package leetcode.leetcode2xx.leetcode281;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagIteratorTest {

    @Test
    void test1() {
        List<Integer> v1 = List.of(1, 2), v2 = List.of(3, 4, 5, 6);
        ZigzagIterator iterator = new ZigzagIterator(v1, v2);
        List<Integer> expected = List.of(1, 3, 2, 4, 5, 6);
        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext()) actual.add(iterator.next());
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        List<Integer> v1 = List.of(1, 1, 1, 1), v2 = List.of(3, 4, 5, 6);
        ZigzagIterator iterator = new ZigzagIterator(v1, v2);
        List<Integer> expected = List.of(1, 3, 1, 4, 1, 5, 1, 6);
        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext()) actual.add(iterator.next());
        assertEquals(expected, actual);
    }
}