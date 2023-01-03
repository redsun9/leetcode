package codeforces.contest1731;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            System.out.println(solve(a));
        }
    }

    private static long solve(int[] nums) {
        int n = nums.length;
        int maxXor = Integer.highestOneBit(n) * 2 - 1;
        int[] count = new int[maxXor + 1];
        count[0] = 1;
        long ans = n * (n + 1L) / 2;
        int xor = 0, maxNum = 0;
        for (int num : nums) {
            xor ^= num;
            maxNum = Math.max(maxNum, num);
            int maxXorCheck = Integer.highestOneBit(maxNum) * 2 - 1;
            for (int i = 0; i < n; i++) {
                int val = i * i;
                if (val > maxXorCheck) break;
                ans -= count[xor ^ val];
            }
            count[xor]++;
        }
        return ans;
    }
}
