package leetcode.leetcode2xx.leetcode249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) map.computeIfAbsent(calculateKey(s), k -> new ArrayList<>()).add(s);
        return new ArrayList<>(map.values());
    }

    private static String calculateKey(String s) {
        char[] arr = s.toCharArray();
        int shift = s.charAt(0) - 'a', n = s.length();
        for (int i = 1; i < n; i++) arr[i] = (char) ('a' + (arr[i] - 'a' - shift + 26) % 26);
        return new String(arr, 1, n - 1);
    }
}
