package leetcode.leetcode3xx.leetcode373;

import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>(Math.min(n1 * n2, k));
        HashSet<Pair> used = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> nums1[x.i] + nums2[x.j]));
        pq.offer(new Pair(0, 0));
        while (k > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            if (used.contains(pair)) continue;
            k--;
            used.add(pair);
            ans.add(List.of(nums1[pair.i], nums2[pair.j]));
            if (pair.i < n1 - 1) pq.offer(new Pair(pair.i + 1, pair.j));
            if (pair.j < n2 - 1) pq.offer(new Pair(pair.i, pair.j + 1));
        }
        return ans;
    }

    private static class Pair {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
