package leetcode.leetcode22xx.leetcode2231;

public class Solution {
    public int largestInteger(int num) {
        int[] count = new int[10];
        int tmp = num;
        while (tmp != 0) {
            count[tmp % 10]++;
            tmp /= 10;
        }

        int ans = 0, even = 0, odd = 1, multiplier = 1;
        tmp = num;
        while (tmp != 0) {
            if (((tmp % 10) & 1) == 0) {
                while (count[even]-- == 0) even += 2;
                ans += even * multiplier;
            } else {
                while (count[odd]-- == 0) odd += 2;
                ans += odd * multiplier;
            }
            tmp /= 10;
            multiplier *= 10;
        }
        return ans;
    }
}
