package leetcode.leetcode14xx.leetcode1447;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //greatest common divisor
    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) ans.add(j + "/" + i);
            }
        }
        return ans;
    }
}
