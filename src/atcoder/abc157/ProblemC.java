package atcoder.abc157;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Integer[] digits = new Integer[n];
        Arrays.fill(digits, null);
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            if (digits[s] == null) {
                digits[s] = c;
            } else {
                if (digits[s] != c) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (digits[0] == null) {
            digits[0] = n == 1 ? 0 : 1;
        }
        if (digits[0] == 0 && n != 1) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i < n; i++) {
            if (digits[i] == null) {
                digits[i] = 0;
            }
        }
        int res = digits[0];
        for (int i = 1; i < n; i++) {
            res = res * 10 + digits[i];
        }
        System.out.println(res);
    }
}
