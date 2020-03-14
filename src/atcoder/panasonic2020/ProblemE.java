package atcoder.panasonic2020;

import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class ProblemE {
    private static final int M = 2000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().toCharArray();
        char[] b = scanner.nextLine().toCharArray();
        char[] c = scanner.nextLine().toCharArray();
        boolean[] ab = new boolean[10 * M];
        boolean[] ac = new boolean[10 * M];
        boolean[] bc = new boolean[10 * M];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (nonMatch(a[i], b[j])) ab[i - j + 5 * M] = true;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (nonMatch(a[i], c[j])) ac[i - j + 5 * M] = true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (nonMatch(b[i], c[j])) bc[i - j + 5 * M] = true;
            }
        }
        int ans = 3 * M;
        for (int i = -2 * M; i <= 2 * M; i++) {
            for (int j = -2 * M; j <= 2 * M; j++) {
                if (!ab[i + 5 * M] && !ac[j + 5 * M] && !bc[j - i + 5 * M]) {
                    int L = min(0, min(i, j));
                    int R = max(a.length, max(b.length + i, c.length + j));
                    ans = min(ans, R - L);
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean nonMatch(char c1, char c2) {
        return c1 != '?' && c2 != '?' && c1 != c2;
    }
}
