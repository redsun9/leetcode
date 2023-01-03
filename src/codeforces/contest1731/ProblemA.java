package codeforces.contest1731;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            long prod = 1;
            for (int i = 0; i < n; i++) prod *= scanner.nextInt();
            System.out.println(2022L * (prod + n - 1));
        }
    }
}
