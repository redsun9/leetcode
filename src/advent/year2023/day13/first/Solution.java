package advent.year2023.day13.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final long base = 29L;
    private static final long mod = Integer.MAX_VALUE;
    private static final int COL_MULTIPLIER = 1;
    private static final int ROW_MULTIPLIER = 100;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day13/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day13/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) {
                    list.add(s);
                } else {
                    if (!list.isEmpty()) {
                        ans += solve(list);
                        list.clear();
                    }
                }
            }
            if (!list.isEmpty()) ans += solve(list);
            printer.println(ans);
        }
    }

    private static int solve(List<String> input) {
        int m = input.size();
        int n = input.get(0).length();

        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = pow[i - 1] * base % mod;

        long[] rowHashes = new long[m];
        for (int i = 0; i < m; i++) {
            String s = input.get(i);
            long hash = 0;
            for (int j = 0; j < n; j++) hash = (hash * base + s.charAt(j)) % mod;
            rowHashes[i] = hash;
        }

        int symmetry = findSymmetry(rowHashes);
        if (symmetry >= 0) return symmetry * ROW_MULTIPLIER;

        long[] colHashes = new long[n];
        for (int j = 0; j < n; j++) {
            long hash = 0;
            for (int i = 0; i < m; i++) hash = (hash * base + input.get(i).charAt(j)) % mod;
            colHashes[j] = hash;
        }

        symmetry = findSymmetry(colHashes);
        return symmetry * COL_MULTIPLIER;
    }

    private static int findSymmetry(long[] nums) {
        int n = nums.length;
        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = pow[i - 1] * base % mod;

        long[] lh = new long[n + 1]; // hash[i] is hash value from str[0..i)
        for (int i = 1; i <= n; i++) lh[i] = (lh[i - 1] * base + nums[i - 1]) % mod;

        long[] rh = new long[n + 1]; // hash[i] is hash value from str[i..n)
        for (int i = n - 1; i >= 0; i--) rh[i] = (rh[i + 1] * base + nums[i]) % mod;

        for (int i = 1; i < n; i++) {
            int len = Math.min(i, n - i);
            if (isPalindromic(i - len, i + len, lh, rh, pow)) return i;
        }
        return -1;
    }

    private static boolean isPalindromic(int l, int r, long[] lh, long[] rh, long[] pow) {
        return lh(l, r, lh, pow) == rh(l, r, rh, pow);
    }

    private static long lh(int l, int r, long[] hash, long[] pow) {
        long ans = (hash[r] - hash[l] * pow[r - l]) % mod;
        if (ans < 0) ans += mod;
        return ans;
    }

    private static long rh(int l, int r, long[] hash, long[] pow) {
        long ans = (hash[l] - hash[r] * pow[r - l]) % mod;
        if (ans < 0) ans += mod;
        return ans;
    }
}
