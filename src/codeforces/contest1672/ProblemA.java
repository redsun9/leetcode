package codeforces.contest1672;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int t = 0; t < numberOfTests; t++) {
            int n = scanner.nextInt();
            long ans = -n;
            for (int i = 0; i < n; i++) ans += scanner.nextInt();
            System.out.println((ans & 1) == 0 ? "maomao90" : "errorgorn");
        }
    }
}
