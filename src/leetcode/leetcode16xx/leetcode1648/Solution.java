package leetcode.leetcode16xx.leetcode1648;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    public int maxProfit(int[] inventory, long orders) {
        Arrays.sort(inventory);
        long n = inventory.length;
        long ans = 0;
        int pos = inventory.length - 1;
        int curHeight = inventory[pos];
        while (true) {
            while (pos > 0 && inventory[pos - 1] == curHeight) pos--;
            int leftHeight = pos > 0 ? inventory[pos - 1] : 0;
            long subOrder = (n - pos) * (curHeight - leftHeight);
            if (subOrder < orders) {
                orders -= subOrder;
                ans += (n - pos) * (curHeight + leftHeight + 1) * (curHeight - leftHeight) / 2;
                curHeight = leftHeight;
                pos--;
            } else {
                long fullRow = orders / (n - pos);
                ans += (n - pos) * (curHeight * 2L - fullRow + 1) * fullRow / 2;
                ans += orders % (n - pos) * (curHeight - fullRow);
                return (int) (ans % p);
            }
        }
    }
}
