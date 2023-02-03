package help_requests.fibonacci_last_digit;


// f(0) = 0
// f(1) = 1
// f(2) = 1
// f(3) = 2
// f(4) = 3
public class Solution {
    public static int fib(int n, int k) {
        if (n <= 1) return n;

        int mod = 1;
        for (int i = 0; i < k; i++) mod *= 10;

        int prev = 0, curr = 1;
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

        int prev = 0, curr = 0, next = 1;
        for (int i = 3; i <= n; i++) {
            int nextNext = (prev + curr + next) % mod;
            prev = curr;
            curr = next;
            next = nextNext;
        }
        return next;
    }
}
