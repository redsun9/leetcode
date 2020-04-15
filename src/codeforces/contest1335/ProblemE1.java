package codeforces.contest1335;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt() - 1;
            }
            int[][] count = new int[n + 1][];
            count[0] = new int[26];
            for (int i = 0; i < n; i++) {
                count[i + 1] = Arrays.copyOfRange(count[i], 0, 26);
                count[i + 1][a[i]]++;
            }
            int ans = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    int mid = 0;
                    int sides = 0;
                    for (int k = 0; k < 26; k++) {
                        mid = Math.max(mid, count[j][k] - count[i][k]);
                        sides = Math.max(sides, Math.min(count[i][k], count[n][k] - count[j][k]));
                    }
                    ans = Math.max(ans, mid + 2 * sides);
                }
            }
            System.out.println(ans);
        }
    }
}
