package tinkoff.min_log_cut;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.println(solve(arr, k));
    }

    static int solve(int[] arr, int k) {
        int lo = 1, hi = 1;
        for (int a : arr) hi = Math.max(hi, a);
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(arr, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] arr, int k, int val) {
        for (int a : arr) {
            k -= (a + val - 1) / val - 1;
            if (k < 0) return false;
        }
        return true;
    }
}
