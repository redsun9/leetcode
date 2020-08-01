package leetcode.leetcode15xx.leetcode1518;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        while (numBottles >= numExchange) {
            int a = numBottles / numExchange;
            int b = numBottles % numExchange;
            ans += numBottles - b;
            numBottles = a + b;
        }
        return ans + numBottles;
    }
}
