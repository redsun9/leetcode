package leetcode.leetcode13;

import java.util.HashMap;

public class Solution {
    private static final HashMap<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = map.get(chars[i]);
        }
        int ans = digits[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (digits[i] >= digits[i + 1]) ans += digits[i];
            else ans -= digits[i];
        }

        return ans;

    }
}
