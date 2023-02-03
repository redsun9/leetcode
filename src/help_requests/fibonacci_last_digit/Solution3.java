package help_requests.fibonacci_last_digit;

public class Solution3 {
    public static int fib(int n, int k) {
        if (n <= 1) return n;

        int mod = 1;
        for (int i = 0; i < k; i++) mod *= 10;

        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] result = {{1, 0}, {0, 1}};
        while (n != 0) {
            if ((n & 1) == 1) result = multiply(result, matrix, mod);
            matrix = multiply(matrix, matrix, mod);
            n >>= 1;
        }
        return result[1][0];
    }

    public static int trib(int n, int k) {
        if (n <= 1) return 0;
        int mod = 1;
        for (int i = 0; i < k; i++) mod *= 10;

        int[][] matrix = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] result = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        while (n != 0) {
            if (n % 2 == 1) result = multiply(result, matrix, mod);
            matrix = multiply(matrix, matrix, mod);
            n >>= 1;
        }
        return result[2][0];
    }

    private static int[][] multiply(int[][] a, int[][] b, int mod) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += (long) a[i][k] * b[k][j] % mod;
                    if (result[i][j] >= mod) result[i][j] -= mod;
                }
            }
        }
        return result;
    }
}
