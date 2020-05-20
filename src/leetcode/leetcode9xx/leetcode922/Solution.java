package leetcode.leetcode9xx.leetcode922;

public class Solution {
    public int[] sortArrayByParityII(int[] a) {
        int even = 0, odd = 1;
        int n = a.length;
        while (true) {
            //for even and odd pointer find first non in correct place
            while (even < n && (a[even] & 1) == 0) even += 2;
            if (even >= n) return a;
            while (odd < n && (a[odd] & 1) == 1) odd += 2;
            int t = a[even];
            a[even] = a[odd];
            a[odd] = t;
            even += 2;
            odd += 2;
        }
    }
}
