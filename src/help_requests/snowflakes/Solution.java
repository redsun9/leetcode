package help_requests.snowflakes;

// n - snowflakes, k = angles
// O(1) - space, O(n^2 * k^2) - time
public class Solution {
    public static boolean allUnique(int[][] snowflakes) {
        int n = snowflakes.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (equalsSnowflake(snowflakes[i], snowflakes[j])) return false;
            }
        }
        return true;
    }

    private static boolean equalsSnowflake(int[] a, int[] b) {
        int n = a.length;
        for (int shift = 0; shift < n; shift++) {
            for (int direction = -1; direction <= 1; direction += 2) {
                boolean ok = true;
                for (int i = 0, j = shift; ok && i < n; i++) {
                    ok = a[i] == b[j];
                    j += direction;
                    if (j < 0) j = n - 1;
                    else if (j == n) j = 0;
                }
                if (ok) return true;
            }
        }
        return false;
    }
}
