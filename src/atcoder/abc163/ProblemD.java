package atcoder.abc163;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long ans = 0;
        for (long i = k; i <= n + 1; i++) {
            long start = i * (i - 1) / 2;
            long end = i * (2 * n - i + 1) / 2;
            ans += end - start + 1;
        }
        System.out.println(ans % 1_000_000_007);
    }
}
