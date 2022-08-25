package help_requests.secure_doors;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int secureWays(int n, int k) {
        HashMap<Key, Integer> cache = new HashMap<>();
        return dfs(true, n, k, cache);
    }

    private static int dfs(boolean previousLocked, int n, int k, Map<Key, Integer> cache) {
        if (n == 0 && k == 0) return 1;
        if (n < k) return 0;
        Key key = new Key(previousLocked, n, k);
        Integer ans = cache.get(key);
        if (ans == null) {
            if (k == 0 && previousLocked) ans = dfs(false, n - 1, 0, cache);
            else if (k == 0) ans = dfs(false, n - 1, 0, cache) + dfs(true, n - 1, 0, cache);
            else if (previousLocked) ans = dfs(true, n - 1, k - 1, cache) + dfs(false, n - 1, k, cache);
            else ans = dfs(true, n - 1, k, cache) + dfs(false, n - 1, k, cache);
            cache.put(key, ans);
        }
        return ans;
    }

    private record Key(boolean previousLocked, int n, int k) {
    }
}
