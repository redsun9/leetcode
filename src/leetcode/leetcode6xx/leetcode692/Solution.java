package leetcode.leetcode6xx.leetcode692;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.compute(word, (key, prevVal) -> prevVal == null ? 1 : prevVal + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue)
                        .thenComparing(
                                Comparator.comparing(
                                        (Function<Map.Entry<String, Integer>, String>) Map.Entry::getKey
                                ).reversed()
                        )
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }
        LinkedList<String> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            ans.addFirst(pq.poll().getKey());
        }
        return ans;
    }
}
