package leetcode.leetcode19xx.leetcode1985;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String str : nums) map.compute(str.length(), (key, val) -> val == null ? 1 : val + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getKey)
        );
        pq.addAll(map.entrySet());
        k = n + 1 - k;
        int sum = 0, len = 0, last = 0;
        while (sum < k) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            last = entry.getValue();
            sum += last;
            len = entry.getKey();
        }
        k = k - sum + last;

        int maxNeeded = 1 + len * last;
        int[][] child = new int[10][maxNeeded];
        int[] count = new int[maxNeeded];
        int[] index = new int[maxNeeded];
        int nxt = 1;

        for (int i = 0; i < n; i++) {
            String s = nums[i];
            if (s.length() == len) {
                int node = 0;
                count[0]++;
                index[0] = i;
                for (int j = 0; j < len; j++) {
                    int c = s.charAt(j) - '0';
                    if (child[c][node] == 0) child[c][node] = nxt++;
                    node = child[c][node];
                    count[node]++;
                    index[node] = i;
                }
            }
        }

        int node = 0;
        for (int i = 0; i < len; i++) {
            int c = 0;
            while (true) {
                if (child[c][node] != 0) {
                    if (count[child[c][node]] >= k) break;
                    k -= count[child[c][node]];
                }
                c++;
            }
            if (count[child[c][node]] == 1) return nums[index[child[c][node]]];
            node = child[c][node];
        }
        return nums[index[node]];
    }
}
