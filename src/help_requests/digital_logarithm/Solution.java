package help_requests.digital_logarithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings({"DuplicatedCode", "DataFlowIssue"})
public class Solution {
    public static int solveWithHashMap(int[] a, int[] b) {
        int[] cnt = new int[10];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (num >= 10) map.compute(num, (k, v) -> v != null ? v == -1 ? null : v + 1 : 1);
            else cnt[num]++;
        }
        for (int num : b) {
            if (num >= 10) map.compute(num, (k, v) -> v != null ? v == 1 ? null : v - 1 : -1);
            else cnt[num]--;
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += Math.abs(entry.getValue());
            cnt[f1(entry.getKey())] += entry.getValue();
        }

        for (int i = 2; i <= 9; i++) ans += Math.abs(cnt[i]);
        return ans;
    }

    public static int solveWithPriorityQueue(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr1) pq1.offer(num);
        for (int num : arr2) pq2.offer(num);
        int ans = 0;
        while (!pq1.isEmpty()) {
            int a = pq1.peek();
            int b = pq2.peek();
            if (a == b) {
                pq1.poll();
                pq2.poll();
            } else {
                if (a > b) pq1.offer(f1(pq1.poll()));
                else pq2.offer(f1(pq2.poll()));
                ans++;
            }
        }
        return ans;
    }

    public static int f1(int n) {
        if (n >= 100_000) {
            if (n >= 10_000_000) {
                if (n >= 100_000_000) return 9;
                else return 8;
            } else {
                if (n >= 1_000_000) return 7;
                else return 6;
            }
        } else {
            if (n >= 1_000) {
                if (n >= 10_000) return 5;
                else return 4;
            } else {
                if (n >= 100) return 3;
                else if (n >= 10) return 2;
                else return 1;
            }
        }
    }

    public static int f2(int n) {
        if (n >= 100_000_000) return 9;
        if (n >= 10_000_000) return 8;
        if (n >= 1_000_000) return 7;
        if (n >= 100_000) return 6;
        if (n >= 10_000) return 5;
        if (n >= 1_000) return 4;
        if (n >= 100) return 3;
        if (n >= 10) return 2;
        return 1;
    }

    public static int f3(int n) {
        return 1 + (int) Math.log10(n);
    }

    public static int f4(int n) {
        int ans = 1;
        while (n >= 10) {
            n /= 10;
            ans++;
        }
        return ans;
    }
}
