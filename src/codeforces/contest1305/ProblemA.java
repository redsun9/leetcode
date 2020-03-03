package codeforces.contest1305;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            StringBuilder sbA = new StringBuilder();
            StringBuilder sbB = new StringBuilder();
            sbA.append(a[0]);
            sbB.append(b[0]);
            for (int j = 1; j < n; j++) {
                sbA.append(' ').append(a[j]);
                sbB.append(' ').append(b[j]);
            }
            System.out.println(sbA.toString());
            System.out.println(sbB.toString());
        }
    }
}
