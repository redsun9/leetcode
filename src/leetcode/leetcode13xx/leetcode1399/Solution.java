package leetcode.leetcode13xx.leetcode1399;

public class Solution {
    public int countLargestGroup(int n) {
        int[] cnt = new int[37];
        int max = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int tmp = i; tmp > 0; tmp /= 10) sum += tmp % 10;
            cnt[sum]++;
            if (cnt[sum] > max) {
                max = cnt[sum];
                ans = 1;
            } else if (cnt[sum] == max) ans++;
        }
        return ans;
    }
}
