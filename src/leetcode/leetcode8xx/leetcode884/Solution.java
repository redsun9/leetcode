package leetcode.leetcode8xx.leetcode884;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] uncommonFromSentences(String a, String b) {
        HashMap<String, Integer> counts = new HashMap<>();
        int size = getWords(a, counts);
        size += getWords(b, counts);
        String[] ans = new String[size];
        int i = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) ans[i++] = entry.getKey();
        }
        return ans;
    }

    private static int getWords(String str, Map<String, Integer> map) {
        int ans = 0;
        int n = str.length();
        int start = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c < 'a' || c > 'z') {
                if (i != start) {
                    String subStr = str.substring(start, i);
                    int prevVal = map.getOrDefault(subStr, 0);
                    if (prevVal == 0) ans++;
                    else if (prevVal == 1) ans--;
                    map.put(subStr, prevVal + 1);
                }
                start = i + 1;
            }
        }
        if (start != n) {
            String subStr = str.substring(start);
            int prevVal = map.getOrDefault(subStr, 0);
            if (prevVal == 0) ans++;
            else if (prevVal == 1) ans--;
            map.put(subStr, prevVal + 1);
        }
        return ans;
    }
}
