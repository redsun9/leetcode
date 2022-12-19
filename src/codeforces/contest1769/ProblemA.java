package codeforces.contest1769;

import java.io.PrintStream;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        int n = scanner.nextInt();
        int prevPos = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            prevPos = Math.max(a - i, prevPos + 1);
            printer.println(prevPos);
        }
    }
}
