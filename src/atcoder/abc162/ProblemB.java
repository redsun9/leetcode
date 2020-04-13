package atcoder.abc162;

import java.util.Scanner;

public class ProblemB {
    private static final int[] a = new int[15];
    private static final int[] d = new int[15];

    static {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < 15; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                sum += i;
                count++;
            }
            a[i] = sum;
            d[i] = count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(f(n));
    }

    public static long f(int n) {
        long b = n / 15;
        int c = n % 15;
        return b * (b - 1) / 2 * 15 * 8 + b * a[14] + a[c] + d[c] * b * 15;
    }
}
