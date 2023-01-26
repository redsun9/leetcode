package help_requests.find_all_duplicates;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static int[] findAllDuplicates(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) count.compute(num, (key, v) -> v == null ? 1 : v + 1);

        int n = arr.length;
        int ansLength = 0;
        for (Integer value : count.values()) if (value >= k) ansLength++;
        int[] ans = new int[ansLength];
        for (int i = 1, pos = 0; i <= n; i++) if (count.getOrDefault(i, 0) >= k) ans[pos++] = i;
        return ans;
    }
}
