package codeforces.contest1335;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            System.out.println((scanner.nextInt() - 1) / 2);
        }
    }
}
