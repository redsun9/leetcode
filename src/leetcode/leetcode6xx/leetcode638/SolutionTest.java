package leetcode.leetcode6xx.leetcode638;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(List.of(3, 0, 5), List.of(1, 2, 10));
        List<Integer> needs = List.of(3, 2);
        assertEquals(14, new Solution().shoppingOffers(price, special, needs));

    }

    @Test
    void test2() {
        List<Integer> price = List.of(2, 3, 4);
        List<List<Integer>> special = List.of(List.of(1, 1, 0, 4), List.of(2, 2, 1, 9));
        List<Integer> needs = List.of(1, 2, 1);
        assertEquals(11, new Solution().shoppingOffers(price, special, needs));
    }
}