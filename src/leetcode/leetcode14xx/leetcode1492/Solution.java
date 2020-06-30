package leetcode.leetcode14xx.leetcode1492;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int kthFactor(int n, int k) {
        if (k == 1) return 1;
        if (n == 1) return -1;
        List<int[]> factors = factorize(n);
        int nFactors = 1;
        for (int[] f : factors) nFactors *= f[1] + 1;
        if (nFactors < k) return -1;
        if (nFactors == k) return n;
        List<Integer> ans = new ArrayList<>();
        generateAllFactors(factors, 1, 0, factors.size(), ans);
        ans.sort(Comparator.naturalOrder());
        return ans.get(k - 1);
    }

    private static void generateAllFactors(List<int[]> factors, int curVal, int curPos, int primeNum, Collection<Integer> tmp) {
        if (curPos == primeNum) {
            tmp.add(curVal);
            return;
        }
        generateAllFactors(factors, curVal, curPos + 1, primeNum, tmp);
        int[] curPrime = factors.get(curPos);
        for (int i = 0; i < curPrime[1]; i++) {
            curVal *= curPrime[0];
            generateAllFactors(factors, curVal, curPos + 1, primeNum, tmp);
        }
    }

    private static List<int[]> factorize(int n) {
        List<int[]> ans = new ArrayList<>();
        if (n % 2 == 0) {
            int c = 0;
            while (n % 2 == 0) {
                c++;
                n /= 2;
            }
            ans.add(new int[]{2, c});
        }
        for (int i = 3; i * i <= n; i += 2) {
            int c = 0;
            while (n % i == 0) {
                c++;
                n /= i;
            }
            if (c != 0) ans.add(new int[]{i, c});
        }
        if (n != 1) ans.add(new int[]{n, 1});
        return ans;
    }
}
