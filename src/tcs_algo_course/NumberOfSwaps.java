package tcs_algo_course;

import java.util.Scanner;

public class NumberOfSwaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        long ans = sortAndCountBad(arr, 0, n);
        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    private static long sortAndCountBad(int[] arr, int start, int end) {
        int len = end - start;
        if (len <= 1) return 0;
        int mid = (start + end) >>> 1;
        long ans = sortAndCountBad(arr, start, mid) + sortAndCountBad(arr, mid, end);
        ans += mergeAndCountBad(arr, start, mid, end);
        return ans;
    }

    private static long mergeAndCountBad(int[] arr, int start, int mid, int end) {
        int len = end - start;
        int[] tmp = new int[len];
        long ans = 0;
        int i = 0, i1 = start, i2 = mid;
        while (i < len) {
            if (i2 == end || i1 < mid && arr[i1] < arr[i2]) tmp[i++] = arr[i1++];
            else {
                ans += mid - i1;
                tmp[i++] = arr[i2++];
            }
        }
        i = 0;
        i1 = start;
        while (i < len) arr[i1++] = tmp[i++];
        return ans;
    }
}
