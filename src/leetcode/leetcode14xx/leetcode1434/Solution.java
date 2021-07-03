package leetcode.leetcode14xx.leetcode1434;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    public static final int TOTAL_HAT_TYPES = 40;
    public static final int p = 1_000_000_007;

    private static int bt(List<Integer>[] hats, int peopleKey, int pos, int types, Integer[][] cache) {
        if (peopleKey == 0) return 1;
        if (pos == types) return 0;
        if (cache[pos][peopleKey] != null) return cache[pos][peopleKey];
        int ans = bt(hats, peopleKey, pos + 1, types, cache);
        for (Integer hat : hats[pos]) {
            if (((peopleKey >> hat) & 1) == 0) continue;
            ans += bt(hats, peopleKey ^ (1 << hat), pos + 1, types, cache);
            if (ans >= p) ans -= p;
        }
        cache[pos][peopleKey] = ans;
        return ans;
    }

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] hatPeople = new List[TOTAL_HAT_TYPES];
        for (int i = 0; i < n; i++) {
            for (Integer hat : hats.get(i)) {
                if (hatPeople[hat - 1] == null) hatPeople[hat - 1] = new ArrayList<>();
                hatPeople[hat - 1].add(i);
            }
        }
        int preferredTypes = 0;
        for (int i = 0; i < TOTAL_HAT_TYPES; i++) {
            if (hatPeople[i] != null) hatPeople[preferredTypes++] = hatPeople[i];
        }
        Integer[][] cache = new Integer[preferredTypes][1 << n];
        return bt(hatPeople, (1 << n) - 1, 0, preferredTypes, cache);
    }
}
