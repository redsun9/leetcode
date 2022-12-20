package help_requests.snowflakes;

import java.util.HashSet;
import java.util.Set;

// n - snowflakes, k = angles
// O(n) - space, O(n * k^2) - time
public class Solution2 {
    private static final int k = 6;
    private static final int MAX_VAL = 1000;

    public static boolean allUnique(int[][] snowflakes) {
        Set<Long> set = new HashSet<>();
        for (int[] snowflake : snowflakes) if (!set.add(canonize(snowflake))) return false;
        return true;
    }

    private static long canonize(int[] arr) {
        long ans = Long.MAX_VALUE;
        for (int shift = 0; shift < k; shift++) {
            for (int direction = -1; direction <= 1; direction += 2) {
                long tmp = 0;
                for (int i = 0, j = shift; i < k; i++) {
                    tmp = tmp * (MAX_VAL + 1) + arr[j];
                    j += direction;
                    if (j < 0) j = k - 1;
                    else if (j == k) j = 0;
                }
                ans = Math.min(ans, tmp);
            }
        }
        return ans;
    }
}
