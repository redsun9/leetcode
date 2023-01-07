package help_requests.spearman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaSolutionTest {
    @Test
    void spearmanUnique() {
        Double[] xs = {106.0, 100.0, 86.0, 101.0, 99.0, 103.0, 97.0, 113.0, 112.0, 110.0};
        Double[] ys = {7.0, 27.0, 2.0, 50.0, 28.0, 29.0, 20.0, 12.0, 6.0, 17.0};
        assertEquals(-0.175757575, JavaSolution.spearmanUnique(xs, ys), 1e-9);
    }

    @Test
    void spearmanNonUnique() {
        Double[] xs = {106.0, 100.0, 86.0, 101.0, 99.0, 103.0, 97.0, 113.0, 112.0, 110.0};
        Double[] ys = {7.0, 27.0, 2.0, 50.0, 28.0, 29.0, 20.0, 12.0, 6.0, 17.0};
        assertEquals(-0.175757575, JavaSolution.spearmanNonUnique(xs, ys), 1e-9);
    }

    @Test
    void test2() {
        Integer[] xs = {3, 2, 1, 4, 3, 2, 5, 1};
        Integer[] ys = {2, 4, 3, 1, 2, 4, 1, 2};

//       [4.5, 2.5, 0.5, 6.0, 4.5, 2.5, 7.0, 0.5]
//        [3.0, 6.5, 5.0, 0.5, 3.0, 6.5, 0.5, 3.0]
        assertEquals(-0.6130952380952381, JavaSolution.spearmanNonUnique(xs, ys), 1e-9);
    }
}