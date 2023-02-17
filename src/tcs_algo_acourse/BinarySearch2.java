package tcs_algo_acourse;

import java.util.Scanner;

public class BinarySearch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        for (int i = 0; i < k; i++) System.out.println(closest(arr, scanner.nextInt()));
    }

    private static int closest(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int ans = arr[0];
        int ansDist = Math.abs(target - arr[0]);
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int tmp = arr[mid];
            if (tmp == target) return target;
            int tmpDist = Math.abs(tmp - target);
            if (tmpDist < ansDist || tmpDist == ansDist && tmp < ans) {
                ans = tmp;
                ansDist = tmpDist;
            }
            if (tmp < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return ans;
    }
}
