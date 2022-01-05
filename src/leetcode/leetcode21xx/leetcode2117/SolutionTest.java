package leetcode.leetcode21xx.leetcode2117;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("24e0", new Solution().abbreviateProduct(1, 4));
    }

    @Test
    void test2() {
        assertEquals("399168e2", new Solution().abbreviateProduct(2, 11));
    }

    @Test
    void test3() {
        assertEquals("7219856259e3", new Solution().abbreviateProduct(371, 375));
    }

    @Test
    void test4() {
        assertEquals("10205...06688e2378", new Solution().abbreviateProduct(44, 9556));
    }

    @Test
    void test5() {
        assertEquals("13554...78176e234", new Solution().abbreviateProduct(4826, 5760));
    }

    @Test
    void test6() {
        assertEquals("36088...36896e337", new Solution().abbreviateProduct(4838, 6186));
    }
}