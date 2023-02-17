package tcs_algo_acourse;

import java.util.Scanner;

public class RootFind2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
        System.out.println(findRootDichotomy(a, b, c, d));
    }


    private static double findRootDichotomy(long a, long b, long c, long d) {
        double lo = -2000, hi = 2000;
        boolean sign = a > 0;
        while (true) {
            double mid = (lo + hi) / 2;
            if (lo == mid || hi == mid) return mid;
            double val = a * mid * mid * mid + b * mid * mid + c * mid + d;
            if (val <= 0 == sign) lo = mid;
            else hi = mid;
        }
    }
}
