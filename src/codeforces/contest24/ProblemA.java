package codeforces.contest24;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][][] ways = new int[n][2][2];
        long sumTotal = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            addWay(a, b, 0, ways);
            addWay(b, a, c, ways);
            sumTotal += c;
        }

        long sum1 = Math.max(ways[0][0][1], 0);
        int prev = 1, curr = ways[0][0][0];
        while (curr != 1) {
            if (ways[curr - 1][0][0] != prev) {
                sum1 += ways[curr - 1][0][1];
                prev = curr;
                curr = ways[curr - 1][0][0];
            } else {
                sum1 += ways[curr - 1][1][1];
                prev = curr;
                curr = ways[curr - 1][1][0];
            }
        }
        System.out.println(Math.min(sum1, sumTotal - sum1));
    }

    private static void addWay(int a, int b, int c, int[][][] ways) {
        if (ways[a - 1][0][0] == 0) {
            ways[a - 1][0][0] = b;
            ways[a - 1][0][1] = c;
        } else {
            ways[a - 1][1][0] = b;
            ways[a - 1][1][1] = c;
        }
    }
}
