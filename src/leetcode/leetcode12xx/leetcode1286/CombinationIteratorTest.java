package leetcode.leetcode12xx.leetcode1286;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationIteratorTest {

    @Test
    void test1() {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        assertTrue(iterator.hasNext());
        assertEquals("ab", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("ac", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("bc", iterator.next());
        assertFalse(iterator.hasNext());
    }
}