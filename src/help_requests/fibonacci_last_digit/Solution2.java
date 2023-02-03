package help_requests.fibonacci_last_digit;

public class Solution2 {
    public static int fib(int n, int k) {
        if (n <= 1) return n;

        int mod = 1;
        for (int i = 0; i < k; i++) mod *= 10;

        int prev = 0, curr = 1, cycleLength = 1;
        while (true) {
            int next = (prev + curr) % mod;
            prev = curr;
            curr = next;
            if (prev == 0 && curr == 1) break;
            cycleLength++;
            if (cycleLength == n) return curr;
        }

        n %= cycleLength;
        if (n <= 1) return n;
        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % mod;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int trib(int n, int k) {
        if (n <= 1) return 0;

        int mod = 1;
        for (int i = 0; i < k; i++) mod *= 10;

        int prev = 0, curr = 0, next = 1, cycleLength = 1;
        while (true) {
            int nextNext = (prev + curr + next) % mod;
            prev = curr;
            curr = next;
            next = nextNext;
            if (prev == 0 && curr == 0 && next == 1) break;
            cycleLength++;
            if (cycleLength == n) return curr;
        }
        n %= cycleLength;
        if (n <= 1) return 0;
        for (int i = 3; i <= n; i++) {
            int nextNext = (prev + curr + next) % mod;
            prev = curr;
            curr = next;
            next = nextNext;
        }
        return next;
    }
}
