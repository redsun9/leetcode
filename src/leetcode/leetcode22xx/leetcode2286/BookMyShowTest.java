package leetcode.leetcode22xx.leetcode2286;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMyShowTest {

    @Test
    void test1() {
        BookMyShow bookMyShow = new BookMyShow(2, 5);
        assertArrayEquals(new int[]{0, 0}, bookMyShow.gather(4, 0));
        assertArrayEquals(new int[0], bookMyShow.gather(2, 0));
        assertTrue(bookMyShow.scatter(5, 1));
        assertFalse(bookMyShow.scatter(5, 1));
    }
}