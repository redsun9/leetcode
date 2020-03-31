package leetcode.leetcode4xx.leetcode432;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllOneTest {

    @Test
    void test1() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        assertEquals("a", allOne.getMinKey());
        allOne.dec("a");
        assertEquals("c", allOne.getMaxKey());
        assertEquals("c", allOne.getMinKey());
    }
}