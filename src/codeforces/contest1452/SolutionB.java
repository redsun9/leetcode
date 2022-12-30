package codeforces.contest1452;

import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                min = Math.min(min, a);
                max = Math.max(max, a);
                sum += a;
            }
            System.out.println(Math.max(max * (n - 1), (sum + n - 2) / (n - 1) * (n - 1)) - sum);
        }
    }
}
