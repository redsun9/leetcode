package leetcode.leetcode20xx.leetcode2011;

public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') ++ans;
            else --ans;
        }
        return ans;
    }
}
