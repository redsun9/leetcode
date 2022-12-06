package help_requests.progress_bars;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        long[] arr = {6};
        List<Integer> expected = List.of(0, 16, 33, 50, 66, 83, 100);
        assertEquals(expected, Solution.getCommonPercents(arr));
    }

    @Test
    void test2() {
        long[] arr = {100, 500};
        List<Integer> expected = List.of(0, 95, 96, 97, 98, 99, 100);
        assertEquals(expected, Solution.getCommonPercents(arr));
    }

    @Test
    void test3() {
        long[] arr = {10000000000L, 2, 2, 9999999998L};
        List<Integer> expected = List.of(0, 50, 99, 100);
        assertEquals(expected, Solution.getCommonPercents(arr));
    }

    @Test
    void test4() {
        long[] arr = {170, 130, 400, 256, 30, 100};
        List<Integer> expected = List.of(0, 17, 43, 44, 84, 90, 99, 100);
        assertEquals(expected, Solution.getCommonPercents(arr));
    }
}