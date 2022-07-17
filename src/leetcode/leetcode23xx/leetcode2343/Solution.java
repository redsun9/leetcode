package leetcode.leetcode23xx.leetcode2343;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length, m = nums[0].length();
        List<Integer>[][] order = new List[m][10];
        for (int j = 0; j < m; j++) {
            List<Integer>[] curr = order[j];
            for (int i = 0; i < 10; i++) curr[i] = new ArrayList<>();
            if (j == 0) {
                for (int i = 0; i < n; i++) curr[nums[i].charAt(m - 1 - j) - '0'].add(i);
            } else {
                for (List<Integer> list : order[j - 1]) for (int i : list) curr[nums[i].charAt(m - 1 - j) - '0'].add(i);
            }
        }

        int numberOfQueries = queries.length;
        int[] ans = new int[numberOfQueries];
        for (int i = 0; i < numberOfQueries; i++) {
            int k = queries[i][1], idx = queries[i][0], digit = 0;
            List<Integer>[] lists = order[k - 1];
            while (idx > lists[digit].size()) idx -= lists[digit++].size();
            ans[i] = lists[digit].get(idx - 1);
        }
        return ans;
    }
}
