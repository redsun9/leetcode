package codeforces.contest1339;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            int p = (n - 1) / 2;
            int q = p + 1;
            while (true) {
                if (p >= 0) {
                    System.out.print(a[p] + " ");
                }
                if (q < n) {
                    System.out.print(a[q] + " ");
                }
                p--;
                q++;
                if (p < 0) break;
            }
            System.out.println();
        }
    }
}
