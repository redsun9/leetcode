package atcoder.abc162;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        int n = s.length();
        int[] chars = new int[n];
        int[][] a = new int[n + 1][3];
        for (int i = n - 1; i >= 0; i--) {
            a[i][0] = a[i + 1][0];
            a[i][1] = a[i + 1][1];
            a[i][2] = a[i + 1][2];
            char c = s.charAt(i);
            if (c == 'R') {
                chars[i] = 0;
            } else if (c == 'G') {
                chars[i] = 1;
            } else {
                chars[i] = 2;
            }
            a[i][chars[i]]++;
        }
        if (a[0][0] == 0 || a[0][1] == 0 || a[0][2] == 0) {
            System.out.println(0);
            return;
        }
        long ans = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (chars[i] != chars[j]) {
                    int req = 3 - chars[i] - chars[j];
                    ans += a[j + 1][req];
                    if (2 * j - i < n && chars[2 * j - i] == req) ans--;
                }
            }
        }
        System.out.println(ans);
    }
}
