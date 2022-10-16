package leetcode.leetcode24xx.leetcode2440;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
            401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
            503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
            601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
            701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797,
            809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887,
            907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
    };

    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        if (n == 1) return 0;
        List<Integer>[] adj = new List[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (adj[u] == null) adj[u] = new ArrayList<>();
            if (adj[v] == null) adj[v] = new ArrayList<>();
            adj[u].add(v);
            adj[v].add(u);
        }

        int sum = 0, maxVal = nums[0];
        for (int num : nums) sum += num;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        int ans = 0, minComponentSum = sum;
        List<Integer> divisors = getAllFactors(sum);
        for (Integer divisor : divisors) {
            if (divisor < maxVal || divisor > minComponentSum) continue;
            int check = check(adj, nums, divisor);
            if (check != -1) {
                ans = check;
                minComponentSum = divisor;
            }
        }
        return ans;
    }

    private static int check(List<Integer>[] adj, int[] nums, int componentSum) {
        DfsResult result = dfs(0, -1, adj, nums, componentSum);
        if (result != DfsResult.failed) return result.ans - 1;
        else return -1;
    }

    private static DfsResult dfs(int u, int parent, List<Integer>[] adj, int[] nums, int componentSum) {
        int remainderSum = nums[u];
        int ans = 0;
        for (Integer v : adj[u]) {
            if (v == parent) continue;
            DfsResult dfs = dfs(v, u, adj, nums, componentSum);
            if (dfs == DfsResult.failed) return DfsResult.failed;
            ans += dfs.ans;
            remainderSum += dfs.remainder;
        }
        if (remainderSum > componentSum) return DfsResult.failed;
        if (remainderSum == componentSum) {
            ans++;
            remainderSum = 0;
        }
        return new DfsResult(ans, remainderSum);
    }

    private static List<Integer> getAllFactors(int n) {
        List<Pair> factors = factorize(n);
        List<Integer> allDivisors = new ArrayList<>();
        dfsFactor(0, factors.size(), 1, factors, allDivisors);
        return allDivisors;
    }

    private static void dfsFactor(int i, int totalFactors, int cur, List<Pair> factors, List<Integer> ans) {
        if (i == totalFactors) ans.add(cur);
        else {
            int maxPower = factors.get(i).power;
            int prime = factors.get(i).prime;
            for (int k = 0; k <= maxPower; k++) {
                dfsFactor(i + 1, totalFactors, cur, factors, ans);
                cur *= prime;
            }
        }
    }

    private static List<Pair> factorize(int n) {
        List<Pair> ans = new ArrayList<>();
        for (int prime : firstPrimes) {
            int cnt = 0;
            while (n % prime == 0) {
                cnt++;
                n /= prime;
            }
            ans.add(new Pair(prime, cnt));
            if (prime * prime > n) break;
        }
        if (n != 1) ans.add(new Pair(n, 1));
        return ans;
    }

    private record Pair(int prime, int power) {
    }

    private record DfsResult(int ans, int remainder) {
        static DfsResult failed = new DfsResult(-1, 0);
    }
}
