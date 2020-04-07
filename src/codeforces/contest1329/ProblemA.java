package codeforces.contest1329;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] l = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = scanner.nextInt();
            if (i + l[i] > n) {
                System.out.println(-1);
                return;
            }
        }
        int[] ans = new int[m];
        long s = 0;
        int left = 0;
        for (int i = 0; i < m; i++) {
            s += l[i];
            ans[i] = i;
            left = Math.max(left, i + l[i]);
        }
        if (s < n) {
            System.out.println(-1);
            return;
        }
        if (left != n) {
            int i = m - 1;
            left = n;
            while (ans[i] + l[i] < left) {
                ans[i] = Math.max(left - l[i], i);
                left = ans[i];
                i--;
            }
        }
        for (int a : ans) {
            System.out.println(a + 1);
        }
    }
}
