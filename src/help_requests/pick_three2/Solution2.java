package help_requests.pick_three2;

import java.util.Arrays;

public class Solution2 {
    public static final int MAX_VAL = 1_000_000;
    private static final int[] cache = new int[MAX_VAL + 1];

    static {
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 0;
        cache[2] = 0;
        cache[3] = 1;
    }

    public static int pickThree(int n) {
        if (cache[n] == -1) {
            int val = pickThree(n / 2) + pickThree(n - n / 2);
            cache[n] = val;
        }
        return cache[n];
    }
}
