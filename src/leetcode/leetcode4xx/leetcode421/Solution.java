package leetcode.leetcode4xx.leetcode421;

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int n = nums.length;
        BinaryTree tree = new BinaryTree(1 + n * 31);
        tree.add(nums[0]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, tree.maxXor(nums[i]));
            tree.add(nums[i]);
        }
        return ans;
    }

    private static class BinaryTree {
        int[][] child;
        int nxt = 1;

        public BinaryTree(int max) {
            child = new int[max][2];
        }

        public void add(int a) {
            int node = 0;
            for (int i = 30; i >= 0; i--) {
                int c = (a >> i) & 1;
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
            }
        }

        public int maxXor(int a) {
            int node = 0;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int c = (a >> i) & 1;
                if (child[node][1 - c] != 0) {
                    node = child[node][1 - c];
                    ans |= 1 << i;
                } else {
                    node = child[node][c];
                }
            }
            return ans;
        }
    }
}
