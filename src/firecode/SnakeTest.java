package firecode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {

    @Test
    void test1() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), Snake.findSpiral(arr));
    }

    @Test
    void test2() {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11);
        assertEquals(expected, Snake.findSpiral(arr));
    }

    @Test
    void testSize() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[][] arr = new int[i][j];
                try {
                    assertEquals(i * j, Snake.findSpiral(arr).size());
                } catch (Throwable e) {
                    System.out.println(i + "," + j);
                    throw e;
                }
            }
        }
    }
}