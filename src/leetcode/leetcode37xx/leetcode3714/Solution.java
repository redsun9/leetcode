package leetcode.leetcode37xx.leetcode3714;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n <= 2) return n;
        Map<Integer, Integer> abMap = new HashMap<>(), acMap = new HashMap<>(), bcMap = new HashMap<>();
        Map<Pair, Integer> abcMap = new HashMap<>();
        abMap.put(0, -1);
        acMap.put(0, -1);
        bcMap.put(0, -1);
        abcMap.put(new Pair(0, 0), -1);
        char prev = 'd';
        int ans = 1;
        for (int i = 0, a = 0, b = 0, c = 0, prevCnt = 0, minAB = -1, minAC = -1, minBC = -1; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == 'a') {
                a++;
                minBC = i;
                bcMap.put(b - c, i);
            } else if (curr == 'b') {
                b++;
                minAC = i;
                acMap.put(a - c, i);
            } else if (curr == 'c') {
                c++;
                minAB = i;
                abMap.put(a - b, i);
            }

            if (curr == 'a' || curr == 'b') {
                Integer p = abMap.putIfAbsent(a - b, i);
                if (p != null && p >= minAB) ans = Math.max(ans, i - p);
                if (p != null && p < minAB) abMap.put(a - b, i);
            }
            if (curr == 'a' || curr == 'c') {
                Integer p = acMap.putIfAbsent(a - c, i);
                if (p != null && p >= minAC) ans = Math.max(ans, i - p);
                if (p != null && p < minAC) acMap.put(a - c, i);
            }
            if (curr == 'b' || curr == 'c') {
                Integer p = bcMap.putIfAbsent(b - c, i);
                if (p != null && p >= minBC) ans = Math.max(ans, i - p);
                if (p != null && p < minBC) bcMap.put(b - c, i);
            }
            Pair key = new Pair(a - b, a - c);
            Integer p = abcMap.putIfAbsent(key, i);
            if (p != null) ans = Math.max(ans, i - p);

            if (prev == curr) ans = Math.max(ans, ++prevCnt);
            else prevCnt = 1;
            prev = curr;
        }
        return ans;
    }

    private record Pair(int ab, int ac) {
    }
}
