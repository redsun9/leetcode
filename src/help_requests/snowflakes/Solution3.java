package help_requests.snowflakes;

import java.util.HashSet;
import java.util.Set;


// n - snowflakes, k = angles
// O(n) - space, O(n * k) - time
public class Solution3 {
    private static final int k = 6;
    private static final int MAX_VAL = 1000;

    public static boolean allUnique(int[][] snowflakes) {
        Set<Long> set = new HashSet<>();
        for (int[] snowflake : snowflakes) if (!set.add(canonize(snowflake))) return false;
        return true;
    }

    private static long canonize(int[] arr) {
        long tmp = 0, pow = 1;
        for (int a : arr) {
            tmp = tmp * (MAX_VAL + 1) + a;
            pow *= MAX_VAL + 1;
        }
        pow /= MAX_VAL + 1; // pow = (MAX_VAL+1)^(k-1)

        long ans = Long.MAX_VALUE;
        //rolling hash
        for (int i = 0; i < k; i++) {
            tmp = (tmp - arr[i] * pow) * (MAX_VAL + 1) + arr[i];
            ans = Math.min(ans, tmp);
        }

        tmp = 0;
        //rolling hash in opposite direction
        for (int i = k - 1; i >= 0; i--) tmp = tmp * (MAX_VAL + 1) + arr[i];
        for (int i = k - 1; i >= 0; i--) {
            tmp = (tmp - arr[i] * pow) * (MAX_VAL + 1) + arr[i];
            ans = Math.min(ans, tmp);
        }
        return ans;
    }
}
