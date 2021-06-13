package leetcode.leetcode18xx.leetcode1899;

public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = 0, b = 0, c = 0;
        int targetA = target[0], targetB = target[1], targetC = target[2];
        for (int[] triplet : triplets) {
            if (triplet[0] <= targetA && triplet[1] <= targetB && triplet[2] <= targetC) {
                a = Math.max(a, triplet[0]);
                b = Math.max(b, triplet[1]);
                c = Math.max(c, triplet[2]);
            }
        }
        return a == targetA && b == targetB && c == targetC;
    }
}
