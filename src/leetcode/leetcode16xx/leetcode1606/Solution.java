package leetcode.leetcode16xx.leetcode1606;

import java.util.*;

// priority queue + ordered set
public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) set.add(i);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            while (!pq.isEmpty() && pq.peek()[0] <= time) set.add(pq.poll()[1]);
            if (set.isEmpty()) continue;
            Integer server = set.ceiling(i % k);
            if (server == null) server = set.pollFirst();
            else set.remove(server);
            count[server]++;
            pq.add(new int[]{time + load[i], server});
        }
        int max = 0;
        for (int a : count) max = Math.max(max, a);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) if (count[i] == max) ans.add(i);
        return ans;
    }
}
