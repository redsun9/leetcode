package leetcode.leetcode25xx.leetcode2520;

public class Solution {
    public int countDigits(int num) {
        int ans = 0, tmp = num;
        while (tmp != 0) {
            if (num % (tmp % 10) == 0) ans++;
            tmp /= 10;
        }
        return ans;
    }
}
