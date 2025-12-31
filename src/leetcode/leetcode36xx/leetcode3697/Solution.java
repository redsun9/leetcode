package leetcode.leetcode36xx.leetcode3697;

public class Solution {
    public int[] decimalRepresentation(int n) {
        int cnt = 0, tmp = n;
        while (tmp != 0) {
            if (tmp % 10 != 0) cnt++;
            tmp /= 10;
        }
        int[] ans = new int[cnt];
        int power = 1, digit;
        while (n != 0) {
            digit = n % 10;
            if (digit != 0) ans[--cnt] = digit * power;
            power *= 10;
            n /= 10;
        }
        return ans;
    }
}
