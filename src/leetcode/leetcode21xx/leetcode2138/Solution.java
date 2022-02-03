package leetcode.leetcode21xx.leetcode2138;

import java.util.Arrays;

public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(n + k - 1) / k];
        char[] tmp = new char[k];

        int fullParts = n / k;
        for (int i = 0, from = 0; i < fullParts; i++) {
            for (int to = 0; to < k; to++, from++) tmp[to] = s.charAt(from);
            ans[i] = new String(tmp);
        }

        if (n % k != 0) {
            int lengthOfPart = n % k;
            for (int from = n / k * k, to = 0; from < n; from++, to++) tmp[to] = s.charAt(from);
            Arrays.fill(tmp, lengthOfPart, k, fill);
            ans[n / k] = new String(tmp);
        }
        return ans;
    }
}
