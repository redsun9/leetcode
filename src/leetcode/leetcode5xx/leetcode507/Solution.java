package leetcode.leetcode5xx.leetcode507;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0 || (num & 1) == 1) return false;
        List<int[]> factors = factorize(num);
        if (factors.size() == 1) return false;
        long sum = 1;
        for (int[] factor : factors) {
            sum = sum * (binPow(factor[0], factor[1] + 1) - 1) / (factor[0] - 1);
        }
        return sum == (num << 1);
    }

    //a^n
    private static long binPow(int a, int n) {
        long res = 1;
        long tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }

    private static List<int[]> factorize(int num) {
        List<int[]> ans = new LinkedList<>();
        int pow2 = 0;
        while ((num & 1) == 0) {
            pow2++;
            num /= 2;
        }
        if (pow2 != 0) ans.add(new int[]{2, pow2});
        int i = 3;
        for (; i * i <= num; i += 2) {
            int count = 0;
            while (num % i == 0) {
                count++;
                num /= i;
            }
            if (count != 0) ans.add(new int[]{i, count});
        }
        if (num != 1) ans.add(new int[]{num, 1});
        return ans;
    }
}
