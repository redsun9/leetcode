package help_requests.jack_house;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static long[] solve(long[] s, long n) {
        long[][] pairs = {{s[0], 0}, {s[1], 1}, {s[2], 2}};
        Arrays.sort(pairs, Comparator.comparingLong(x -> x[0]));
        long[] solve3d = solve3d(pairs[0][0], pairs[1][0], pairs[2][0], n);
        long[] ans = new long[4];
        for (int i = 0; i < 3; i++) ans[(int) pairs[i][1] + 1] = solve3d[i];
        ans[0] = ans[1] * ans[2] * ans[3];
        return ans;
    }


    // a<=b<=c
    public static long[] solve3d(long a, long b, long c, long n) {
        if (a * b * c < n) return new long[4];
        long maxS1 = 1, maxS2 = 1, maxS3 = 1, maxV = 1;

        long min = Math.min(a, n);
        long threshold = (long) Math.sqrt(min);
        if ((threshold + 1) * (threshold + 1) <= min) threshold++;

        long d1, n1, n23, v;
        long[] solve2d;
        for (long i = 1; i <= threshold; i++) {
            //i - number of pieces of A be broken into
            n1 = i;
            d1 = a / n1;
            n23 = (n + n1 - 1) / n1;

            solve2d = solve2d(b, c, n23);
            v = d1 * solve2d[0] * solve2d[1];
            if (v > maxV) {
                maxS1 = d1;
                maxS2 = solve2d[0];
                maxS3 = solve2d[1];
                maxV = v;
            }

            //i - size of pieces "A" be broken into
            d1 = i;
            n1 = a / i;
            n23 = (n + n1 - 1) / n1;
            solve2d = solve2d(b, c, n23);
            v = d1 * solve2d[0] * solve2d[1];
            if (v > maxV) {
                maxS1 = d1;
                maxS2 = solve2d[0];
                maxS3 = solve2d[1];
                maxV = v;
            }
        }
        return new long[]{maxS1, maxS2, maxS3};
    }

    // a<=b
    @SuppressWarnings("DuplicatedCode")
    public static long[] solve2d(long a, long b, long n) {
        if (a * b < n) return new long[2];

        long maxS1 = 1, maxS2 = 1, maxV = 1;
        long min = Math.min(a, n);
        long threshold = (long) Math.sqrt(min);
        if ((threshold + 1) * (threshold + 1) <= min) threshold++;

        long d1, d2, n1, n2, v;
        for (long i = 1; i <= threshold; i++) {
            //i - number of pieces of A be broken into
            n1 = i;
            d1 = a / n1;
            n2 = (n + n1 - 1) / n1;
            d2 = b / n2;
            v = d1 * d2;
            if (v > maxV) {
                maxS1 = d1;
                maxS2 = d2;
                maxV = v;
            }

            //i - size of pieces "A" be broken into
            d1 = i;
            n1 = a / i;
            n2 = (n + n1 - 1) / n1;
            d2 = b / n2;
            v = d1 * d2;
            if (v > maxV) {
                maxS1 = d1;
                maxS2 = d2;
                maxV = v;
            }
        }
        return new long[]{maxS1, maxS2};
    }
}
