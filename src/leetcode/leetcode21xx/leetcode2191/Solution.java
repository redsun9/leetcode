package leetcode.leetcode21xx.leetcode2191;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int maxLength = 9;
    private static final int maxWeight = 100_000_000;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> child = new ArrayList<>();
        child.add(new int[10]);
        List<List<Integer>> indices = new ArrayList<>();
        indices.add(null);
        int nxt = 1;
        int n = nums.length;
        for (int idx = 0; idx < n; idx++) {
            int num = nums[idx];
            int node = 0;
            boolean firstDigitMet = false;
            for (int i = 1, weight = maxWeight; i <= maxLength; i++, weight /= 10) {
                int digit = num / weight % 10;
                firstDigitMet |= digit != 0 || i == maxLength;
                int c = firstDigitMet ? mapping[digit] : 0;
                if (child.get(node)[c] == 0) {
                    child.add(new int[10]);
                    indices.add(null);
                    child.get(node)[c] = nxt++;
                }
                node = child.get(node)[c];
            }
            if (indices.get(node) == null) indices.set(node, new ArrayList<>());
            indices.get(node).add(idx);
        }

        int[] ans = new int[n];
        int pos = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            List<Integer> list = indices.get(node);
            if (list != null) for (Integer idx : list) ans[pos++] = nums[idx];
            for (int nextNode : child.get(node)) if (nextNode != 0) queue.addLast(nextNode);
        }
        return ans;
    }
}
