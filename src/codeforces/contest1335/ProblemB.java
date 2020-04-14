package codeforces.contest1335;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                ans[i] = (char) ('a' + i % b);
            }
            System.out.println(new String(ans));
        }
    }
}
