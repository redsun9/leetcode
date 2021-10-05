package leetcode.leetcode3xx.leetcode308;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {

    @Test
    void test1() {
        int[][] a = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix st = new NumMatrix(a);
        assertEquals(8, st.sumRegion(2, 1, 4, 3));
        st.update(3, 2, 2);
        assertEquals(10, st.sumRegion(2, 1, 4, 3));
    }
}