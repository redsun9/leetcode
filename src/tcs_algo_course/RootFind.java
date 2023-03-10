package tcs_algo_course;

import java.util.Scanner;

public class RootFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c = Double.parseDouble(scanner.nextLine().trim());
        System.out.println(findRoot(c));
    }


    private static double findRoot(double c) {
        double lo = 0, hi = Math.sqrt(c);
        while (Math.abs(lo - hi) >= 1e-9) {
            double mid = (lo + hi) / 2.0;
            double x = mid * mid + Math.sqrt(mid + 1.0);
            if (x < c) lo = mid;
            else hi = mid;
        }
        return lo;
    }
}
