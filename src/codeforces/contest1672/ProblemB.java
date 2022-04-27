package codeforces.contest1672;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < numberOfTests; t++) {
            String s = scanner.nextLine();
            int n = s.length();
            boolean ok = true;
            int countA = 0, countB = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'A') countA++;
                else countB++;
                ok &= countA >= countB;
            }
            ok &= s.charAt(n - 1) == 'B';
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
