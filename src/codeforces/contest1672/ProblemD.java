package codeforces.contest1672;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int t = 0; t < numberOfTests; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = scanner.nextInt();
            for (int i = 1; i <= n; i++) b[i] = scanner.nextInt();
            int[] c = new int[n + 1];
            int[] num = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                num[a[i]]++;
                c[i] = num[a[i]];
            }
            Arrays.fill(num, 0);
            int idx = 1;
            for (int i = 1; i <= n; i++) {
                num[b[i]]++;
                while (idx <= n && (a[idx] != b[i] || c[idx] < num[b[i]])) idx++;
            }
            if (idx <= n) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
