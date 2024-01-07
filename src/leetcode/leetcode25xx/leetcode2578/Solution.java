package leetcode.leetcode25xx.leetcode2578;

public class Solution {
    public int splitNum(int num) {
        int[] cnt = new int[10];
        while (num != 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        int[] ans = new int[2];
        for (int i = 1, total = 0; i <= 9; i++) {
            while (cnt[i]-- != 0) {
                ans[total & 1] = ans[total & 1] * 10 + i;
                total++;
            }
        }
        return ans[0] + ans[1];
    }
}
