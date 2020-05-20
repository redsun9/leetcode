package leetcode.leetcode4xx.leetcode451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.merge(c, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x.getValue()));
        pq.addAll(count.entrySet());
        char[] ans = new char[s.length()];
        int pos = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            Character c = entry.getKey();
            for (int i = entry.getValue(); i > 0; i--) {
                ans[pos++] = c;
            }
        }
        return new String(ans);
    }
}
