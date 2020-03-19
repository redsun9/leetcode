package leetcode.leetcode30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int num = words.length;
        if (words.length == 0) return Collections.emptyList();
        int n = s.length();
        int len = words[0].length();
        if (n - num * len + 1 <= 0) return Collections.emptyList();
        Map<String, Integer> need = new HashMap<>();
        for (String word : words) {
            need.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }
        final List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int l = i;
            final Map<String, Integer> seen = new HashMap<>();
            final Queue<String> queue = new ArrayDeque<>();
            for (int j = i; j <= n - len; j += len) {
                String word = s.substring(j, j + len);
                if (need.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    queue.offer(word);
                    if (seen.get(word) > need.get(word)) {
                        String polled = null;
                        while (!word.equals(polled)) {
                            polled = queue.poll();
                            seen.put(polled, seen.get(polled) - 1);
                            l += len;
                        }
                    }
                    if (queue.size() == num) {
                        ans.add(l);
                        String polled = queue.poll();
                        seen.put(polled, seen.get(polled) - 1);
                        l += len;
                    }
                } else {
                    seen.clear();
                    queue.clear();
                    l = j + len;
                }
            }
        }
        return ans;
    }
}
