package leetcode.leetcode3xx.leetcode304;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {

    @Test
    void test() {
        int[][] a = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] requests = {{2, 1, 4, 3}, {1, 1, 2, 2}, {1, 2, 2, 4}};
        int[] expected = {8, 11, 12};
        NumMatrix matrix = new NumMatrix(a);
        NumMatrix2 matrix2 = new NumMatrix2(a);
        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            assertEquals(expected[i], matrix.sumRegion(request[0], request[1], request[2], request[3]));
            assertEquals(expected[i], matrix2.sumRegion(request[0], request[1], request[2], request[3]));
        }
    }
}