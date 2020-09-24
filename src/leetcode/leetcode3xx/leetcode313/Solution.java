package leetcode.leetcode3xx.leetcode313;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n-- == 1) return 1;
        int k = primes.length;
        int[] maxForPrimes = new int[k];
        for (int i = 0; i < k; i++) maxForPrimes[i] = Integer.MAX_VALUE / primes[i];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (int i = 0; i < k; i++) pq.add(new Node(primes[i], i));
        while (true) {
            Node node = pq.poll();
            int val = node.val;
            if (--n == 0) return val;
            for (int i = node.idx; i < k && val <= maxForPrimes[i]; i++) {
                pq.add(new Node(val * primes[i], i));
            }
        }
    }

    private static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
