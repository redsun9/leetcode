package leetcode.leetcode7xx.leetcode788;

public class Solution {
    private static final int[] all = {1, 7, 49, 343, 2401}; // 7^n
    private static final int[] diff = {0, 4, 40, 316, 2320}; // 7^n - 3^n

    //    0,1,2,5,6,8,9
    private static final int[] floorAll = {0, 1, 2, 3, 3, 3, 4, 5, 5, 6};
    private static final int[] floorDiff = {0, 0, 0, 1, 1, 1, 2, 3, 3, 3};
    private static final int[] floorSame = {0, 1, 2, 2, 2, 2, 2, 2, 2, 3};

    public int rotatedDigits(int n) {
        int[] d = new int[5];
        int dc = -1;
        do {
            d[++dc] = n % 10;
            n /= 10;
        } while (n != 0);

        int ans = 0;
        boolean seamed = false;
        while (dc >= 0) {
            int digit = d[dc];
            if (seamed) ans += floorAll[digit] * all[dc];
            else ans += floorDiff[digit] * all[dc] + floorSame[digit] * diff[dc];
            if (digit == 3 || digit == 4 || digit == 7) break;
            seamed |= digit == 2 || digit == 5 || digit == 6 || digit == 9;
            dc--;
        }
        if (dc < 0 && seamed) ans++;
        return ans;
    }
}
