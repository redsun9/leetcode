package microsoft.maxcircle;

import java.util.HashMap;

public class Solution {
    public int solution(String s, int[] x, int[] y) {
        HashMap<Character, Long> map = new HashMap<>();
        int n = s.length();
        long maxR = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long r = x[i] * (long) x[i] + y[i] * (long) y[i];
            char c = s.charAt(i);
            long prevVal = map.getOrDefault(c, Long.MAX_VALUE);
            maxR = Math.min(maxR, Math.max(prevVal, r));
            map.put(c, Math.min(r, prevVal));
        }
        int ans = 0;
        for (Long value : map.values()) if (value < maxR) ans++;
        return ans;
    }
}
