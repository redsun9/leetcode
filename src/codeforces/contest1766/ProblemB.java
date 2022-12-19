package codeforces.contest1766;

import java.util.BitSet;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            String s = scanner.nextLine().trim();
            System.out.println(solve(s) ? "YES" : "NO");
        }
    }

    private static boolean solve(String s) {
        int n = s.length();
        if (n <= 3) return false;
        BitSet set = new BitSet(26 * 26);
        for (int i = 2; i < n; i++) {
            int c2 = (s.charAt(i - 1) - 'a') * 26 + (s.charAt(i) - 'a');
            if (set.get(c2)) return true;
            int c1 = (s.charAt(i - 2) - 'a') * 26 + (s.charAt(i - 1) - 'a');
            set.set(c1);
        }
        return false;
    }
}
