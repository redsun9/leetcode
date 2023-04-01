package leetcode.leetcode25xx.leetcode2554;


import java.util.HashSet;
import java.util.Set;


// O(n+k) time, O(k) space, where k is the number of banned numbers
public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> map = new HashSet<>();
        for (int i : banned) map.add(i);
        int ans = 0, curSum = 0;
        for (int i = 1; i <= n; i++) {
            if (map.contains(i)) continue;
            curSum += i;
            if (curSum <= maxSum) ans++;
            else return ans;
        }
        return ans;
    }
}
