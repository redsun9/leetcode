package leetcode.leetcode36xx.leetcode3680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void generateSchedule() {
        Solution solution = new Solution();
        for (int n = 5; n <= 50; n++) {
            int[][] schedule = solution.generateSchedule(n);
            int total = n * (n - 1);
            assertEquals(schedule.length, total);

            boolean ok = true;
            boolean[][] used = new boolean[n][n];

            for (int[] match : schedule) used[match[0]][match[1]] = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    ok &= used[i][j];
                }
            }

            for (int j = 1; j < total; j++) {
                ok &= schedule[j - 1][0] != schedule[j][0] && schedule[j - 1][0] != schedule[j][1] && schedule[j - 1][1] != schedule[j][0] && schedule[j - 1][1] != schedule[j][1];
            }
            assertTrue(ok);
        }
    }
}