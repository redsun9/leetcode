package atcoder.abc161;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int ai = scanner.nextInt();
            a[i] = ai;
            sum += ai;
        }
        double d = 1.0 * sum / (4 * m);
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= d) c++;
        }

        if (c >= m) System.out.println("Yes");
        else System.out.println("No");
    }
}
