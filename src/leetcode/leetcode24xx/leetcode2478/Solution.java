package leetcode.leetcode24xx.leetcode2478;

public class Solution {
    public static final int p = 1_000_000_007;

    public int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            arr[i + 1] = c == 2 || c == 3 || c == 5 || c == 7;
        }
        if (arr[n]) return 0;

        for (int i = n; i > 0; i--) arr[i] &= !arr[i - 1];

        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        prev[0] = 1;

        for (int j = 0; j < k; j++) {
            for (int to = 1, from = j * minLength, sum = 0; to <= n; to++) {
                if (to - from < minLength) next[to] = 0;
                if (to - from == minLength) {
                    if (arr[from + 1]) {
                        sum += prev[from];
                        if (sum >= p) sum -= p;
                    }
                    next[to] = sum;
                    from++;
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[n];
    }
}
