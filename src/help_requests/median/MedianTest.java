package help_requests.median;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class MedianTest {

    @Test
    void test1() {
        double[] arr = {1, 2, 3, 4};
        List<Double> expected = List.of(0.0, 2.5, 5.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test2() {
        double[] arr = {1, 3, 4};
        List<Double> expected = List.of(0.0, 2.0, 6.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test3() {
        double[] arr = {1, 1, 1, 2};
        List<Double> expected = List.of(0.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test4() {
        double[] arr = {1, 1, 1, 1, 2};
        List<Double> expected = List.of(0.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test5() {
        double[] arr = {1, 2, 4, 8};
        List<Double> expected = List.of(-5.0, 3.75, 5.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test6() {
        double[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256};
        List<Double> expected = List.of(-391.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test7() {
        double[] arr = {1, 1, 1, 1};
        List<Double> expected = List.of(1.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }

    @Test
    void test8() {
        double[] arr = {1, 1, 1};
        List<Double> expected = List.of(1.0);
        List<Double> actual = Median.solve(arr).stream().sorted().toList();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 1e-6);
        }
    }
}