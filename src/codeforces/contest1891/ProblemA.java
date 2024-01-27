package codeforces.contest1891;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
            System.out.println(solve(nums) ? "YES" : "NO");
        }
    }

    public static boolean solve(int[] nums) {
        int n = nums.length;
        if (n <= 3) return true;
        int start = 2, end = 4;
        while (start != n) {
            for (int i = start + 1; i < end; i++) if (nums[i - 1] > nums[i]) return false;
            start = end;
            end = Math.min(end * 2, nums.length);
        }
        return true;
    }
}
