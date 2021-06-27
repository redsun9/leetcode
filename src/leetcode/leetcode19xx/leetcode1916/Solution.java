package leetcode.leetcode19xx.leetcode1916;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    private static final int p = 1_000_000_007;

    private static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (t < 0) t += p;
        return t;
    }

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] children = new List[n];
        for (int i = 1; i < n; i++) {
            int father = prevRoom[i];
            if (children[father] == null) children[father] = new LinkedList<>();
            children[father].add(i);
        }

        int[] factors = new int[n];
        int[] reverseFactors = new int[n];
        factors[0] = 1;
        reverseFactors[0] = 1;
        for (int i = 1; i < n; i++) factors[i] = (int) (factors[i - 1] * (long) i % p);

        int[] size = new int[n];
        Arrays.fill(size, 1);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            Integer peek = queue.peekLast();
            if (dp[peek] == -1) {
                dp[peek] = 1;
                if (children[peek] != null) {
                    for (Integer child : children[peek]) {
                        queue.addLast(child);
                    }
                }
            } else {
                queue.pollLast();
                if (children[peek] != null) {
                    int tmp = 1;
                    for (Integer child : children[peek]) {
                        size[peek] += size[child];
                        int reverseFactor = reverseFactors[size[child]];
                        if (reverseFactor == 0) {
                            reverseFactor = reverse(factors[size[child]]);
                            reverseFactors[size[child]] = reverseFactor;
                        }
                        tmp = (int) ((long) tmp * dp[child] % p * reverseFactor % p);
                    }
                    dp[peek] = (int) ((long) tmp * factors[size[peek] - 1] % p);
                }
            }
        }
        return dp[0];
    }
}
