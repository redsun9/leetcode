package leetcode.leetcode19xx.leetcode1998;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313
    };

    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> primeToFirstPosition = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        for (int u = 0; u < n; u++) {
            int num = nums[u];
            for (int prime : primes) {
                if (prime * prime > num) break;
                if (num % prime == 0) {
                    Integer v = primeToFirstPosition.putIfAbsent(prime, u);
                    if (v != null) uf.union(u, v);
                    while (num % prime == 0) num /= prime;
                }
            }
            if (num != 1) {
                Integer v = primeToFirstPosition.putIfAbsent(num, u);
                if (v != null) uf.union(u, v);
            }
        }

        HashMap<Integer, PriorityQueue<Integer>> gm = new HashMap<>();
        for (int i = 0; i < n; i++) gm.computeIfAbsent(uf.find(i), k -> new PriorityQueue<>()).offer(nums[i]);

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) if (gm.get(uf.find(i)).poll() != nums[i]) return false;
        return true;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (x == p[x]) return x;
            else {
                p[x] = find(p[x]);
                return p[x];
            }
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (rank[x] < rank[y]) p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y]) ++rank[x];
            }
        }
    }
}
