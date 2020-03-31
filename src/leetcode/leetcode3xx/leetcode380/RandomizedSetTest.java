package leetcode.leetcode3xx.leetcode380;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    void test1() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(1));
        assertFalse(set.remove(2));
        assertTrue(set.insert(2));
        HashSet<Integer> expected = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            expected.add(set.getRandom());
        }
        assertTrue(expected.contains(1));
        assertTrue(expected.contains(2));
        ;
        assertTrue(set.remove(1));
        assertFalse(set.insert(2));
        for (int i = 0; i < 100; i++) {
            assertEquals(2, set.getRandom());
        }
    }
}