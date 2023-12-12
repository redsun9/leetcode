package advent.year2023.day12.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int K = 5;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day12/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day12/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) ans += solve(scanner.nextLine().trim());
            printer.println(ans);
        }
    }

    private static long solve(String input) {
        String[] split1 = input.split(" +");
        String str = split1[0];
        int m = str.length();

        String[] split2 = split1[1].split(",");
        int n = split2.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(split2[i]);

        Map<Key, Long> cache = new HashMap<>();
        return dfs(0, 0, 0, 0, 0, str, nums, cache);
    }

    // '#' - 1, '.' - 0, '?' - ?

    private static long dfs(
            int strPos, int groupPos, int numPos, int k1, int k2,
            String str, int[] nums, Map<Key, Long> cache
    ) {
        Key key = new Key(strPos, numPos, groupPos, k1, k2);
        if (strPos == str.length() + 1 && k1 < K - 1 || strPos == str.length() && k1 == K - 1) {
            k1++;
            strPos = 0;
        }
        boolean shouldBeSkipped = false;
        if (numPos == nums[groupPos]) {
            groupPos++;
            numPos = 0;
            shouldBeSkipped = true;
            if (groupPos == nums.length) {
                k2++;
                groupPos = 0;
            }
        }
        if (k1 == K && k2 == K) return 1;
        if (k1 == K) return 0;

        char c = strPos < str.length() ? str.charAt(strPos) : '?';
        if (c == '#' && k2 == K) return 0;
        if (c == '#' && shouldBeSkipped) return 0;
        if (c == '.' && numPos != 0) return 0;

        if (cache.containsKey(key)) return cache.get(key);

        long ans = 0;
        if (shouldBeSkipped || k2 == K || c == '.')
            ans = dfs(strPos + 1, groupPos, numPos, k1, k2, str, nums, cache);

        else if (numPos != 0 || c == '#')
            ans = dfs(strPos + 1, groupPos, numPos + 1, k1, k2, str, nums, cache);

        else ans = dfs(strPos + 1, groupPos, numPos + 1, k1, k2, str, nums, cache) +
                    dfs(strPos + 1, groupPos, numPos, k1, k2, str, nums, cache);
        cache.put(key, ans);
        return ans;
    }

    private record Key(int strPos, int numPos, int groupPos, int k1, int k2) {
    }
}