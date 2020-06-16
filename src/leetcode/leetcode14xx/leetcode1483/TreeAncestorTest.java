package leetcode.leetcode14xx.leetcode1483;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeAncestorTest {

    @Test
    void test1() {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor ta = new TreeAncestor(7, parent);
        assertEquals(1, ta.getKthAncestor(3, 1));
        assertEquals(0, ta.getKthAncestor(5, 2));
        assertEquals(-1, ta.getKthAncestor(6, 3));

    }
}