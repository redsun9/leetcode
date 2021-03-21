package leetcode.leetcode18xx.leetcode1803;

public class Solution {
    private static final int MAX_BITS = 15;
    private static final int MAX_MASK = 1 << (MAX_BITS - 1);
    private static final int MAX_CHANGE = (1 << MAX_BITS) - 1;

    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        Trie trie = new Trie(MAX_BITS * n + 1);
        int ans = 0;
        for (int num : nums) {
            ans += trie.countPrefix(num, low, high);
            trie.addVal(num);
        }
        return ans;
    }

    private static class Trie {
        int[][] child;
        int[] value;
        int nxt = 1;

        public Trie(int max) {
            child = new int[max][2];
            value = new int[max];
        }

        public void addVal(int val) {
            int node = 0;
            value[0]++;
            for (int i = MAX_BITS - 1, mask = MAX_MASK; i >= 0; i--, mask >>= 1) {
                int c = (val & mask) == 0 ? 0 : 1;
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
                value[node]++;
            }
        }

        public int countPrefix(int val, int lo, int hi) {
            return countPrefix(val, lo, hi, 0, 0, MAX_MASK, MAX_CHANGE);
        }

        private int countPrefix(
                int val, int lo, int hi, int curVal, int curNode, int mask, int change
        ) {
            if (curVal + change < lo || curVal > hi) return 0;
            if (curVal >= lo && curVal + change <= hi) return value[curNode];
            int c = (val & mask);
            int ans = 0;
            if (child[curNode][0] != 0) {
                ans += countPrefix(val, lo, hi, curVal ^ c, child[curNode][0], mask >> 1, change >> 1);
            }
            if (child[curNode][1] != 0) {
                ans += countPrefix(val, lo, hi, curVal ^ c ^ mask, child[curNode][1], mask >> 1, change >> 1);
            }
            return ans;
        }
    }
}
