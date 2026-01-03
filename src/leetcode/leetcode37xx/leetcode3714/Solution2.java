package leetcode.leetcode37xx.leetcode3714;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n <= 2) return n;
        Map<Key, Integer> map = new HashMap<>();
        for (KeyType keyType : KeyType.values()) map.put(new Key(keyType, 0, 0), -1);
        int ans = 0;
        int[] curr = new int[3];
        for (int i = 0; i < s.length(); i++) {
            curr[s.charAt(i) - 'a']++;
            for (Key key : new Key[]{
                    new Key(KeyType.ABC, curr[0] - curr[1], curr[0] - curr[2]),
                    new Key(KeyType.AB, curr[0] - curr[1], curr[2]),
                    new Key(KeyType.AC, curr[0] - curr[2], curr[1]),
                    new Key(KeyType.BC, curr[1] - curr[2], curr[0]),
                    new Key(KeyType.A, curr[1], curr[2]),
                    new Key(KeyType.B, curr[0], curr[2]),
                    new Key(KeyType.C, curr[0], curr[1])
            }) {
                Integer prev = map.putIfAbsent(key, i);
                if (prev != null) ans = Math.max(ans, i - prev);
            }
        }
        return ans;
    }

    private record Key(KeyType type, int a, int b) {
    }

    private enum KeyType {
        ABC,
        AB,
        AC,
        BC,
        A,
        B,
        C
    }
}
