package leetcode.leetcode37xx.leetcode3771;

public class Solution2 {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        for (int i = 1; i < n; i++) damage[i] += damage[i - 1];

        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (requirement[j] > hp) continue;
            if (hp - damage[j] >= requirement[j]) {
                ans += j + 1;
                continue;
            }
            int lo = 0, hi = j;
            while (lo < hi) {
                int i = (lo + hi) / 2;
                if (requirement[j] - hp + damage[j] > damage[i]) lo = i + 1;
                else hi = i;
            }
            ans += j - lo;
        }
        return ans;
    }
}
