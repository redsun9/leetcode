package leetcode.leetcode21xx.leetcode2121;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            map.computeIfAbsent(num, x -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];
        for (List<Integer> list : map.values()) {
            int k = list.size();
            long sum = 0;
            for (int idx : list) sum += idx;

            for (int i = 0; i < k; i++) {
                int idx = list.get(i);
                ans[idx] = sum - (k - 2L * i) * idx;
                sum -= 2L * idx;
            }
        }
        return ans;

    }
}
