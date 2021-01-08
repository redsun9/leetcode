package leetcode.leetcode12xx.leetcode1203;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int n = 8, m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = List.of(
                List.of(),
                List.of(6),
                List.of(5),
                List.of(6),
                List.of(3, 6),
                List.of(),
                List.of(),
                List.of()
        );

        int[] ans = new Solution().sortItems(n, m, Arrays.copyOf(group, n), beforeItems);
        assertEquals(n, ans.length);
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] expectedMinMax = {3, 2};
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        for (int i = 0; i < ans.length; i++) {
            int member = ans[i];
            assertTrue(member >= 0);
            assertTrue(member < n);
            pos[member] = i;
            if (group[member] != -1) {
                min[group[member]] = Math.min(min[group[member]], i);
                max[group[member]] = Math.max(max[group[member]], i);
            }
        }
        for (int i = 0; i < n; i++) assertTrue(pos[i] != -1);
        for (int i = 0; i < m; i++) assertEquals(expectedMinMax[i], max[i] - min[i] + 1);
        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer prev : beforeItems.get(i)) {
                assertTrue(pos[i] > pos[prev]);
            }
        }
    }
}