package codeforces.contest1305;

import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int pMax = 0;
        for (int i = 2; i < n; i++) {
            pMax += i / 2;
        }
        if (pMax < m) {
            System.out.println(-1);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println("1 2");
            return;
        }
        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2;
        int k = 2;
        while (m >= k / 2) {
            ans[k] = k + 1;
            m -= k / 2;
            k++;
        }
        if (k < n && m != 0) {
            ans[k] = 2 * k - 2 * m + 1;
            k++;
        }
        int diff = ans[k - 1] + ans[k - 2] + 1;
        for (int i = n - 1; i >= k; i--) {
            ans[i] = 1_000_000_000 - diff * (n - 1 - i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 2");
        for (int i = 2; i < n; i++) {
            sb.append(' ').append(ans[i]);
        }
        System.out.println(sb.toString());
    }
}
