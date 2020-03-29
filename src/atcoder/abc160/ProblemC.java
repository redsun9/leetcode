package atcoder.abc160;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int[] a = new int[k];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int maxDistance = 0;
        for (int i = 1; i < n; i++) {
            maxDistance = Math.max(maxDistance, a[i] - a[i - 1]);
        }
        maxDistance = Math.max(maxDistance, a[0] + k - a[n - 1]);

        System.out.println(k - maxDistance);


    }
}
