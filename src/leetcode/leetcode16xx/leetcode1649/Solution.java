package leetcode.leetcode16xx.leetcode1649;

public class Solution {
    private static final int MAX_NUM = 100_000;
    private static final int p = 1_000_000_007;

    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int ans = 0;
        Fenwick fenwick = new Fenwick(MAX_NUM);
        for (int i = 0; i < n; i++) {
            int instruction = instructions[i];
            ans += Math.min(fenwick.get(instruction - 1), i - fenwick.get(instruction));
            if (ans >= p) ans -= p;
            fenwick.update(instruction);
        }
        return ans;
    }

    private static class Fenwick {
        private final int[] arr;
        private final int n;

        Fenwick(int n) {
            arr = new int[n + 1];
            this.n = n;
        }

        void update(int x) {
            while (x <= n) {
                arr[x]++;
                x += x & -x;
            }
        }

        int get(int x) {
            int ans = 0;
            while (x > 0) {
                ans += arr[x];
                x -= x & -x;
            }
            return ans;
        }
    }
}
