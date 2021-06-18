package leetcode.leetcode11xx.leetcode1157;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityCheckerTest {

    @Test
    void test1() {
        int[] arr = {1, 1, 2, 2, 1, 1};
        MajorityChecker checker = new MajorityChecker(arr);
        assertEquals(1, checker.query(0, 5, 4));
        assertEquals(-1, checker.query(0, 3, 3));
        assertEquals(2, checker.query(2, 3, 2));
    }

    @Test
    void testGetCount1() {
        List<Integer> list = List.of(0, 1, 4, 5);
        assertEquals(2, MajorityChecker.getCount(list, 0, 2));
    }

    @Test
    void testGetCount2() {
        List<Integer> list = List.of(0, 1, 4, 5);
        assertEquals(2, MajorityChecker.getCount(list, 0, 4));
    }
}