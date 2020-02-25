package atcoder.abc154;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(maxMathExpectation(p, k));
    }

    public static float maxMathExpectation(int[] p, int k) {
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += p[i];
        }
        int max = tmp;
        for (int i = k; i < p.length; i++) {
            tmp += p[i] - p[i - k];
            max = Math.max(max, tmp);
        }
        return (max + k) / 2.0f;
    }
}
