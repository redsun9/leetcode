package leetcode.leetcode21xx.leetcode2100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        List<Integer> expected = List.of(2, 3);
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }

    @Test
    void test2() {
        int[] security = {1, 1, 1, 1, 1};
        int time = 0;
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }

    @Test
    void test3() {
        int[] security = {1, 2, 3, 4, 5, 6};
        int time = 2;
        List<Integer> expected = List.of();
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }

    @Test
    void test4() {
        int[] security = {1};
        int time = 5;
        List<Integer> expected = List.of();
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }

    @Test
    void test5() {
        int[] security = {4, 6, 13, 21, 30, 12, 21, 23, 28};
        int time = 2;
        List<Integer> expected = List.of();
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }

    @Test
    void test6() {
        int n = 100000;
        int[] security = new int[n];
        int time = 24738;
        List<Integer> expected = new ArrayList<>();
        for (int m = time, r = 2 * time; r < n; m++, r++) expected.add(m);
        assertEquals(expected, new Solution().goodDaysToRobBank(security, time));
    }
}