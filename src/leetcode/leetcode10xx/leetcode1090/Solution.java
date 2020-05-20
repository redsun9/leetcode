package leetcode.leetcode10xx.leetcode1090;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x.val));
        for (int i = 0; i < n; i++) {
            pq.offer(new Item(values[i], labels[i]));
        }
        HashMap<Integer, Integer> used = new HashMap<>();
        int ans = 0;
        while (numWanted != 0 && !pq.isEmpty()) {
            Item item = pq.poll();
            Integer count = used.merge(item.label, 1, Integer::sum);
            if (count <= useLimit) {
                ans += item.val;
                numWanted--;
            }
        }
        return ans;
    }

    private static class Item {
        int val, label;

        public Item(int val, int label) {
            this.val = val;
            this.label = label;
        }
    }
}
