package leetcode.leetcode26xx.leetcode2600;

public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        ans += Math.min(numOnes, k);
        k -= Math.min(numOnes, k);
        k -= Math.min(numZeros, k);
        ans -= k;
        return ans;
    }
}
