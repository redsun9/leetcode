package codeforces.contest1408;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println(solve(arr, l));
        }
    }

    private static double solve(int[] arr, int l) {
        int n = arr.length;
        if (n == 0) return l / 2.0;
        double tl = 0, tr = 0;
        double xl = 0, xr = l;
        int i = 0, j = n - 1;
        while (i <= j) {
            double nextTL = tl + (arr[i] - xl) / (double) (i + 1);
            double nextTR = tr + (xr - arr[j]) / (double) (n - j);
            if (nextTL <= nextTR) {
                tl = nextTL;
                xl = arr[i++];
            } else {
                tr = nextTR;
                xr = arr[j--];
            }
        }
        double bt = Math.max(tl, tr);
        return bt + (xr - xl - (bt - tl) * (i + 1) - (bt - tr) * (n - j)) / (n + 2);
    }
}
