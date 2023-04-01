package codeforces.contest1795;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) a[j] = scanner.nextInt();
            int[] b = new int[n];
            for (int j = 0; j < n; j++) b[j] = scanner.nextInt();
            long[] ans = solve(a, b);
            for (long x : ans) System.out.print(x + " ");
            System.out.println();
        }
    }

    public static long[] solve(int[] a, int[] b) {
        int n = a.length;
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) prefSum[i + 1] = prefSum[i] + b[i];
        long[] ans = new long[n];
        long[] nonCompleteCount = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long threshold = a[i] + prefSum[i];
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefSum[mid + 1] >= threshold) r = mid;
                else l = mid + 1;
            }
            if (l < n) {
                ans[l] += threshold - prefSum[l];
                nonCompleteCount[l]++;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] += (i + 1 - nonCompleteCount[i]) * b[i];
            nonCompleteCount[i + 1] += nonCompleteCount[i];
        }
        return ans;
    }

    private static long[] solve2(int[] a, int[] b) {
        int n = a.length;
        long[] ans = new long[n];
        long prefSum = 0, newPrefSum;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(a[i] + prefSum);
            newPrefSum = prefSum + b[i];
            while (!pq.isEmpty() && pq.peek() <= newPrefSum) ans[i] += pq.poll() - prefSum;
            ans[i] += (long) pq.size() * b[i];
            prefSum = newPrefSum;
        }
        return ans;
    }
}
