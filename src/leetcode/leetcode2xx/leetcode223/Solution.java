package leetcode.leetcode2xx.leetcode223;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l = Math.max(A, E);
        int t = Math.max(B, F);
        int r = Math.min(C, G);
        int b = Math.min(D, H);
        int s = (C - A) * (D - B) + (G - E) * (H - F);
        if (r > l && b > t) s -= (r - l) * (b - t);
        return s;
    }
}
