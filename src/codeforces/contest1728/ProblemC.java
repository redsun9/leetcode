package codeforces.contest1728;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int[] a, int[] b) {
        int n = a.length;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (num >= 10) map.compute(num, (k, v) -> v != null ? v + 1 : 1);
            else cnt1[num]++;
        }
        int ans = 0;
        for (int num : b) {
            if (num >= 10) {
                if (map.containsKey(num)) map.compute(num, (k, v) -> v == 1 ? null : v - 1);
                else {
                    cnt2[f(num)]++;
                    ans++;
                }
            } else {
                cnt2[num]++;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt1[f(entry.getKey())] += entry.getValue();
            ans += entry.getValue();
        }
        for (int i = 9; i >= 2; i--) ans += Math.abs(cnt1[i] - cnt2[i]);
        return ans;
    }

    //only for num>=10
    private static int f(int n) {
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
                else return 2;
            }
        }
    }
}
