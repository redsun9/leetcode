package codeforces.contest1795;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            boolean ans = solve(s1, s2);
            System.out.println(ans ? "YES" : "NO");
        }
    }

    private static boolean solve(String s1, String s2) {
        int cnt = 0;
        int n1 = s1.length(), n2 = s2.length();
        for (int i = 1; i < n1; i++) if (s1.charAt(i - 1) == s1.charAt(i)) cnt++;
        for (int i = 1; i < n2; i++) if (s2.charAt(i - 1) == s2.charAt(i)) cnt++;
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) cnt++;
        return cnt < 2;
    }
}
