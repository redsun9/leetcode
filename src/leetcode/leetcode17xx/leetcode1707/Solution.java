package leetcode.leetcode17xx.leetcode1707;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static final int NUM_BITS = 31;
    public static final int HIGHEST_BIT = 1 << (NUM_BITS - 1);

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        Trie trie = new Trie(n * 31 + 1);
        Arrays.sort(nums);
        int m = queries.length;
        int[][] orderedQueries = new int[m][3];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            orderedQueries[i][0] = query[1];
            orderedQueries[i][1] = query[0];
            orderedQueries[i][2] = i;
        }
        Arrays.sort(orderedQueries, Comparator.comparingInt(arr -> arr[0]));
        int[] ans = new int[m];
        int i = 0;
        for (int[] query : orderedQueries) {
            int mi = query[0];
            int index = query[2];
            while (i < n && nums[i] <= mi) trie.addInt(nums[i++]);
            if (i == 0) ans[index] = -1;
            else ans[index] = trie.maxXor(query[1]);
        }
        return ans;
    }

    private static class Trie {
        int[] child;
        int nxt = 2;

        Trie(int max) {
            child = new int[max * 2];
        }

        void addInt(int num) {
            int node = 0;
            for (int i = 0, mask = HIGHEST_BIT; i < NUM_BITS; i++, mask >>= 1) {
                int c = (num & mask) == 0 ? 0 : 1;
                if (child[node + c] == 0) {
                    child[node + c] = nxt;
                    nxt += 2;
                }
                node = child[node + c];
            }
        }

        int maxXor(int num) {
            int node = 0;
            int ans = 0;
            for (int i = 0, mask = HIGHEST_BIT; i < NUM_BITS; i++, mask >>= 1) {
                int c = (num & mask) == 0 ? 0 : 1;
                if (child[node + 1 - c] != 0) {
                    ans |= mask;
                    node = child[node + 1 - c];
                } else {
                    node = child[node + c];
                }
            }
            return ans;
        }
    }
}
