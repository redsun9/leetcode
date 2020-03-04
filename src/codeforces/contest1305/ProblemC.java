package codeforces.contest1305;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (m != 1) {
            boolean[] d = new boolean[m];
            int[] a = new int[m];
            for (int i = 0; i < n; i++) {
                int ai = scanner.nextInt();
                int mi = ai % m;
                if (d[mi]) {
                    System.out.println(0);
                    return;
                }
                d[mi] = true;
                a[mi] = ai;

            }
            int res = 1;
            for (int i = 0; i < m - 1; i++) {
                if (!d[i]) continue;
                for (int j = i + 1; j < m; j++) {
                    if (!d[j]) continue;
                    res = res * (Math.abs(a[i] - a[j]) % m) % m;
                }
            }
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }
}
