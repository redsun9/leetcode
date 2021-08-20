package codeforces.contest334006;

import java.util.Scanner;

@SuppressWarnings("SuspiciousNameCombination")
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();
        for (int t = 0; t < testNumber; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(solve(x, y, a, b));
        }
    }

    static int solve(int x, int y, int a, int b) {
        if (a == b) return Math.min(x, y) / a;
        int tmp;
        if (x < y) {
            tmp = x;
            x = y;
            y = tmp;
        }
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }

        int t1 = min((x - y) / (a - b), x / a, y / b);
        x -= a * t1;
        y -= b * t1;

        int t2 = Math.min(x, y) / (a + b);

        x -= t2 * (a + b);
        y -= t2 * (a + b);

        if (x >= a && y >= b) t1++;

        return t1 + 2 * t2;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
