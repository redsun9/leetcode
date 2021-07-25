package leetcode.leetcode19xx.leetcode1948;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        int n = paths.size();
        Map<Integer, Integer>[] child = new Map[n + 1];
        for (int i = 0; i <= n; i++) child[i] = new TreeMap<>();

        int[] pathIdForNode = new int[n + 1];
        int[] virtualIds = new int[n + 1];
        int[] counters = {1, 1, 1}; // nxt,stringCounter, idCounter

        HashMap<String, Integer> stringMap = new HashMap<>();
        Map<String, Integer> idMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> path = paths.get(i);
            int node = 0;
            for (String s : path) {
                int stringId = stringMap.compute(s, (k, v) -> v != null ? v : counters[1]);
                if (stringId == counters[1]) counters[1]++;
                node = child[node].compute(stringId, (k, v) -> v != null ? v : counters[0]);
                if (node == counters[0]) counters[0]++;
            }
            pathIdForNode[node] = i;
        }

        boolean[] processed = new boolean[counters[0]];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        while (!stack.isEmpty()) {
            Integer peek = stack.peekLast();
            if (processed[peek]) {
                stack.pollLast();
                if (!child[peek].isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<Integer, Integer> entry : child[peek].entrySet()) {
                        sb.append(entry.getKey()).append(':').append(virtualIds[entry.getValue()]).append(',');
                    }
                    String hash = sb.toString();
                    Integer id = idMap.compute(hash, (k, v) -> v != null ? v : counters[2]);
                    if (id == counters[2]) counters[2]++;
                    virtualIds[peek] = id;
                    countMap.compute(id, (k, v) -> v == null ? 1 : v + 1);
                }
            } else {
                processed[peek] = true;
                for (Integer value : child[peek].values()) stack.addLast(value);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int node = stack.poll();
            if (node == 0 || (virtualIds[node] == 0 || countMap.get(virtualIds[node]) == 1)) {
                stack.addAll(child[node].values());
                if (node != 0) ans.add(paths.get(pathIdForNode[node]));
            }
        }
        return ans;
    }
}
