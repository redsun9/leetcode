package leetcode.leetcode18xx.leetcode1806;


// this perfect out-shuffle, so we look for minimal positive k such 2^k = 1 (mod n-1)
// https://en.wikipedia.org/wiki/Faro_shuffle

public class Solution {
    public int reinitializePermutation(int n) {
        if (n == 2) return 1;
        int k = 1, a = 2;
        while (a != 1) {
            k++;
            a = a * 2 % (n - 1);
        }
        return k;
    }
}
