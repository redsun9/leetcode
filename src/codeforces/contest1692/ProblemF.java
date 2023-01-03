package codeforces.contest1692;

import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] count = new int[10];
            for (int i = 0; i < n; i++) count[scanner.nextInt() % 10]++;
            System.out.println(solve(count) ? "YES" : "NO");
        }
    }

    private static boolean solve(int[] count) {
        for (int a = 0; a < 10; a++) {
            for (int b = a; b < 10; b++) {
                int c = (23 - a - b) % 10;
                if (c < b) continue;
                if (a == b && b == c) {
                    if (count[a] >= 3) return true;
                } else if (a == b) {
                    if (count[a] >= 2 && count[c] != 0) return true;
                } else if (b == c) {
                    if (count[a] != 0 && count[b] >= 2) return true;
                } else {
                    if (count[a] != 0 && count[b] != 0 && count[c] != 0) return true;
                }
            }
        }
        return false;
    }
}
