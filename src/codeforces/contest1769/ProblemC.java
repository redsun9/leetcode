package codeforces.contest1769;

import java.io.PrintStream;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int ans = 0, prev = Integer.MIN_VALUE, len = 0, lenPlus1 = 0;
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (a == prev) lenPlus1 = Math.max(len + 1, lenPlus1);
                else if (a == prev + 1) {
                    len = Math.max(lenPlus1, len + 1);
                    lenPlus1 = lenPlus1 + 1;
                } else if (a == prev + 2) {
                    len = lenPlus1 + 1;
                    lenPlus1 = 1;
                } else {
                    len = 1;
                    lenPlus1 = 1;
                }
                ans = Math.max(ans, len);
                ans = Math.max(ans, lenPlus1);
                prev = a;
            }
            printer.println(ans);
        }
    }
}
