package leetcode.leetcode10xx.leetcode1044;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

//binary search + rolling hash
public class Solution {
    private static final long base = 29L;
    private static final long mod = Integer.MAX_VALUE;

    private static int findDuplicateOfLength(char[] a, int n, int len) {
        long p = mod - BigInteger.valueOf(base).modPow(BigInteger.valueOf(len), BigInteger.valueOf(mod)).intValue();
        long hash = 0;
        for (int i = 0; i < len; i++) hash = (hash * base + a[i]) % mod;
        HashMap<Long, Collection<Integer>> map = new HashMap<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.add(0);
        map.put(hash, tmp);
        for (int start = 1, end = len; end < n; start++, end++) {
            hash = (hash * base + a[end] + a[start - 1] * p) % mod;
            Collection<Integer> list = map.getOrDefault(hash, new LinkedList<>());
            for (Integer prev : list) {
                if (same(a, prev, start, len)) return start;
            }
            list.add(start);
            map.put(hash, list);
        }
        return -1;
    }

    private static boolean same(char[] a, int i1, int i2, int length) {
        for (int i = 0; i < length; i++) {
            if (a[i1 + i] != a[i2 + i]) return false;
        }
        return true;
    }

    public String longestDupSubstring(String s) {
        int n = s.length();
        if (n < 2) return "";
        char[] chars = s.toCharArray();
        int lo = 0, hi = n, ansStart = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int res = findDuplicateOfLength(chars, n, mid);
            if (res >= 0) {
                lo = mid;
                ansStart = res;
            } else hi = mid - 1;
        }
        return new String(chars, ansStart, lo);
    }
}
