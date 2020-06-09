package leetcode.leetcode11xx.leetcode1146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnapshotArrayTest {

    @Test
    void test1() {
        SnapshotArray sa = new SnapshotArray(3);
        sa.set(0, 5);
        assertEquals(0, sa.snap());
        sa.set(0, 6);
        assertEquals(5, sa.get(0, 0));
    }

    @Test
    void test2() {
        SnapshotArray sa = new SnapshotArray(4);
        assertEquals(0, sa.snap());
        assertEquals(1, sa.snap());
        assertEquals(0, sa.get(3, 1));
        sa.set(2, 4);
        assertEquals(2, sa.snap());
        sa.set(1, 4);
    }
}