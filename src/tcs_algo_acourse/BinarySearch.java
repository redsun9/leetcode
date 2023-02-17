package tcs_algo_acourse;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        for (int i = 0; i < k; i++) System.out.println(binarySearch(arr, scanner.nextInt()) ? "YES" : "NO");
    }

    private static boolean binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
