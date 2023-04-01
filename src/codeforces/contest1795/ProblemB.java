package codeforces.contest1795;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean left = false, right = false;
            for (int j = 0; j < n; j++) {
                left |= scanner.nextInt() == k;
                right |= scanner.nextInt() == k;
            }
            boolean ans = left && right;
            System.out.println(ans ? "YES" : "NO");
        }
    }
}
