package help_requests.pick_three;

public class Solution2 {
    public static final int MAX_VAL = 1_000_000;
    private static final int[] cache = new int[MAX_VAL + 1];

    static {
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 1;
        cache[3] = 1;
    }

    public static int pickThree(int n) {
        if (cache[n] == 0) {
            int val = pickThree(n / 2) + pickThree(n - n / 2);
            cache[n] = val;
        }
        return cache[n];
    }
}
