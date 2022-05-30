package leetcode.leetcode22xx.leetcode2288;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        String expected = "there are $0.50 $1.00 and 5$ candies in the shop";
        int discount = 50;
        assertEquals(expected, new Solution().discountPrices(sentence, discount));
    }

    @Test
    void test2() {
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        String expected = "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$";
        int discount = 100;
        assertEquals(expected, new Solution().discountPrices(sentence, discount));
    }


    @Test
    void test3() {
        String sentence = "$76111 ab $6 $";
        String expected = "$39577.72 ab $3.12 $";
        int discount = 48;
        assertEquals(expected, new Solution().discountPrices(sentence, discount));
    }
}