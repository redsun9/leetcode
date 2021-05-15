package leetcode.leetcode17xx.leetcode1728;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String[] grid = {"####F", "#C...", "M...."};
        int catJump = 1, mouseJump = 2;
        assertTrue(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test2() {
        String[] grid = {"M.C...F"};
        int catJump = 1, mouseJump = 4;
        assertTrue(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test3() {
        String[] grid = {"M.C...F"};
        int catJump = 1, mouseJump = 3;
        assertFalse(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test4() {
        String[] grid = {"C...#", "...#F", "....#", "M...."};
        int catJump = 2, mouseJump = 5;
        assertFalse(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test5() {
        String[] grid = {".M...", "..#..", "#..#.", "C#.#.", "...#F"};
        int catJump = 3, mouseJump = 1;
        assertTrue(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test6() {
        String[] grid = {"..#C", "...#", "..M.", "#F..", "...."};
        int catJump = 2, mouseJump = 1;
        assertTrue(new Solution().canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    void test7() {
        String[] grid = {
                ".....M",
                "##.#.#",
                "#....#",
                ".##...",
                "...C..",
                "F.....",
                ".#..#."
        };
        int catJump = 1, mouseJump = 5;
        assertFalse(new Solution().canMouseWin(grid, catJump, mouseJump));
    }
}