package help_requests.fibonacci_encoder;

import org.junit.jupiter.api.Assertions;

import java.util.Random;

//encode fibonacci strings (
// arr[i]==1 => arr[i+1]==0
public class FibonacciEncoder {
    private static final int k = 92;
    private static final long[] weights;

    static {
        weights = new long[k - 1];
        weights[k - 2] = 1;
        weights[k - 3] = 2;
        for (int i = k - 4; i >= 0; i--) weights[i] = weights[i + 1] + weights[i + 2];
    }

    // arr of length k
    private static long encodeHelper(boolean[] arr, int start, int end) {
        long ans = 0;
        for (int i = start, j = 0; i < end; i++, j++) if (arr[i]) ans += weights[j];
        return ans;
    }

    private static boolean[] decodeHelper(long ans) {
        boolean[] arr = new boolean[k];
        int i = 0;
        while (ans != 0) {
            if (Long.compareUnsigned(ans, weights[i]) >= 0) {
                arr[i] = true;
                ans -= weights[i];
                i += 2;
            } else i += 1;
        }
        return arr;
    }

    public static long[] encode(boolean[] arr) {
        final int n = arr.length;
        final int ansLength;
        if (n <= 1) ansLength = 1;
        else if (n <= k) ansLength = 2;
        else ansLength = 2 + (n - 2) / (k - 1);
        long[] ans = new long[ansLength];
        ans[0] = n;

        for (int i = 1, start = 0; start + 1 < n; i++, start += k - 1) {
            ans[i] = encodeHelper(arr, start, Math.min(n - 1, start + k - 1));
        }
        return ans;
    }
    public static boolean[] decode(long[] ans) {
        final int n = (int) ans[0];
        boolean[] arr = new boolean[n];
        for (int i = 1, start = 0; start + 1 < n; i++, start += k - 1) {
            boolean[] buf = decodeHelper(ans[i]);
            System.arraycopy(buf, 0, arr, start, Math.min(n - 1, start + k - 1) - start);
        }
        return arr;
    }
    public static void main(String[] args) {
        long max = Long.parseUnsignedLong("12200160415121876738");
        int testsForHelper = 1_000_000;
        Random random = new Random(0);
        while (testsForHelper != 0) {
            long key = random.nextLong();
            if (Long.compareUnsigned(max, key) <= 0) continue;
            Assertions.assertEquals(key, encodeHelper(decodeHelper(key), 0, k));
            testsForHelper--;
        }

        int testsForEncoder = 1_000;
        while (testsForEncoder != 0) {
            int n = 10 + random.nextInt(1000);
            boolean[] expected = new boolean[n];
            int i = n - 2;
            while (i >= 0) {
                if (random.nextBoolean()) {
                    expected[i] = true;
                    i -= 2;
                } else i--;
            }
            boolean[] actual = decode(encode(expected));
            Assertions.assertArrayEquals(expected, actual);
            testsForEncoder--;
        }


    }
}
