package help_requests.new_order;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String x = "zyxwvutsrqponmlkjihgfedcba";
        String[] arr = {"abd", "bsk", "ak", "a", "b", "ldlajd"};
        int n = arr.length;
        String[] expected = {"ldlajd", "b", "bsk", "a", "ak", "abd"};
        String[] actual1 = Solution.sortWithNewAlphabetOrder(Arrays.copyOf(arr, n), x);
        String[] actual2 = Solution2.sortWithNewAlphabetOrder(Arrays.copyOf(arr, n), x);
        String[] actual3 = Solution3.sortWithNewAlphabetOrder(Arrays.copyOf(arr, n), x);

        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
        assertArrayEquals(expected, actual3);
    }
}