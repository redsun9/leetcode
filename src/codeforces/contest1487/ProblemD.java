package codeforces.contest1487;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int x = (int) Math.round((Math.sqrt(2 * n - 1) - 1) / 2);
            if (2 * x * (x + 1) + 1 > n) x--;
            System.out.println(x);
        }
    }
}
