package codeforces.contest1735;

import java.util.Scanner;

@SuppressWarnings("IntegerMultiplicationImplicitCastToLong")
public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
            int a = Integer.MAX_VALUE;
            for (int num : nums) a = Math.min(a, num);
            long ans = 0;
            for (int num : nums) ans += (num + 2 * a - 2) / (2 * a - 1) - 1;
            System.out.println(ans);
        }
    }
}
