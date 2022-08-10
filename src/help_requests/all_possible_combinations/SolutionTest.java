package help_requests.all_possible_combinations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void getAllPossibleCombinations() {
        int[][] ranges = {{2, 3}, {4, 6}, {3, 5}};
        List<int[]> expected = List.of(
                new int[]{2, 4, 3},
                new int[]{2, 4, 4},
                new int[]{2, 4, 5},
                new int[]{2, 5, 3},
                new int[]{2, 5, 4},
                new int[]{2, 5, 5},
                new int[]{2, 6, 3},
                new int[]{2, 6, 4},
                new int[]{2, 6, 5},
                new int[]{3, 4, 3},
                new int[]{3, 4, 4},
                new int[]{3, 4, 5},
                new int[]{3, 5, 3},
                new int[]{3, 5, 4},
                new int[]{3, 5, 5},
                new int[]{3, 6, 3},
                new int[]{3, 6, 4},
                new int[]{3, 6, 5}
        );
        List<int[]> actual = Solution.getAllPossibleCombinations(ranges);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) assertArrayEquals(expected.get(i), actual.get(i));
    }
}