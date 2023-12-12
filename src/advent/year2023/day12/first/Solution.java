package advent.year2023.day12.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day12/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day12/first/output.txt");
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
        return dfs(0, 0, 0, str, nums, cache);
    }

    // '#' - 1, '.' - 0, '?' - ?

    private static long dfs(
            int strPos, int groupPos, int numPos,
            String str, int[] nums, Map<Key, Long> cache
    ) {
        Key key = new Key(strPos, numPos, groupPos);
        boolean shouldBeSkipped = false;
        if (groupPos < nums.length && numPos == nums[groupPos]) {
            groupPos++;
            numPos = 0;
            shouldBeSkipped = true;
        }
        if (strPos == str.length() && groupPos == nums.length) return 1;     // both ends
        if (strPos == str.length()) return 0;                                // str ends
        if (str.charAt(strPos) == '#' && groupPos == nums.length) return 0;  // groups ended, but there is 1
        if (str.charAt(strPos) == '#' && shouldBeSkipped) return 0;          // should be skipped, but there is 1
        if (str.charAt(strPos) == '.' && numPos != 0) return 0;              // should be skipped, but group continues

        if (cache.containsKey(key)) return cache.get(key);

        long ans = 0;
        if (shouldBeSkipped || groupPos == nums.length || str.charAt(strPos) == '.')
            ans = dfs(strPos + 1, groupPos, numPos, str, nums, cache);
        else if (numPos != 0 || str.charAt(strPos) == '#')
            ans = dfs(strPos + 1, groupPos, numPos + 1, str, nums, cache);
        else ans = dfs(strPos + 1, groupPos, numPos + 1, str, nums, cache) +
                    dfs(strPos + 1, groupPos, numPos, str, nums, cache);
        cache.put(key, ans);
        return ans;
    }


    private record Key(int strPos, int numPos, int groupPos) {
    }
}
