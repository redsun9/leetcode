package leetcode.leetcode8xx.leetcode841;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] arr = {{1}, {2}, {3}, {}};
        List<List<Integer>> rooms = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> room = new ArrayList<>();
            for (int a : ints) room.add(a);
            rooms.add(room);
        }
        assertTrue(new Solution().canVisitAllRooms(rooms));
    }

    @Test
    void test2() {
        int[][] arr = {{1, 3}, {3, 0, 1}, {2}, {0}};
        List<List<Integer>> rooms = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> room = new ArrayList<>();
            for (int a : ints) room.add(a);
            rooms.add(room);
        }
        assertFalse(new Solution().canVisitAllRooms(rooms));
    }
}