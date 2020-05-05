package leetcode.leetcode13xx.leetcode1349;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        char[][] seats = {{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}};
        assertEquals(4, new Solution().maxStudents(seats));
    }
}