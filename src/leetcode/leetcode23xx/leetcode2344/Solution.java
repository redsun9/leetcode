package leetcode.leetcode23xx.leetcode2344;

import java.util.PriorityQueue;

public class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int num : numsDivide) gcd = gcd(gcd, num);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.offer(num);
        int ans = 0;
        while (!pq.isEmpty() && gcd % pq.poll() != 0) ans++;
        return ans == nums.length ? -1 : ans;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
