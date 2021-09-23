package leetcode.leetcode2xx.leetcode247;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        char[] mirrored = {'0', '1', '8'};
        if (n == 1) return List.of("0", "1", "8");
        char[] num = new char[n];

        boolean isOdd = (n & 1) == 1;
        int ml = n / 2 - 1;
        int midPos = n / 2;

        int m = binPow(ml);
        List<String> ans = new ArrayList<>(4 * m * (isOdd ? 3 : 1));
        for (int start = 1; start <= 4; start++) {
            num[0] = pairs[start][0];
            num[n - 1] = pairs[start][1];

            for (int mid = 0; mid < m; mid++) {
                int tmp = mid;
                for (int j = 0, i1 = 1, i2 = n - 2; j < ml; j++, tmp /= 5, i1++, i2--) {
                    int d = tmp % 5;
                    num[i1] = pairs[d][0];
                    num[i2] = pairs[d][1];
                }
                if (isOdd) {
                    for (int i = 0; i < 3; i++) {
                        num[midPos] = mirrored[i];
                        ans.add(new String(num));
                    }
                } else {
                    ans.add(new String(num));
                }
            }
        }
        return ans;
    }


    //a^n
    private static int binPow(int n) {
        int res = 1;
        int tmp = 5;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
