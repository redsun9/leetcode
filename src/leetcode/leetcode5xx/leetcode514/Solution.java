package leetcode.leetcode5xx.leetcode514;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] letterPositions = new List[26];
        int d = ring.length();
        for (int i = 0; i < d; i++) {
            int c = ring.charAt(i) - 'a';
            if (letterPositions[c] == null) letterPositions[c] = new LinkedList<>();
            letterPositions[c].add(i);
        }

        int n = key.length();
        int[] dp = new int[d];
        int prevChar = key.charAt(0) - 'a';
        List<Integer> prevPositions = letterPositions[prevChar];
        for (Integer prevPos : prevPositions) dp[prevPos] = Math.min(prevPos, d - prevPos);
        for (int i = 1; i < n; i++) {
            int curChar = key.charAt(i) - 'a';
            if (curChar == prevChar) continue;
            List<Integer> currentPositions = letterPositions[curChar];
            for (Integer curPos : currentPositions) {
                int min = Integer.MAX_VALUE;
                for (Integer prevPos : prevPositions) {
                    int diff = Math.abs(prevPos - curPos);
                    min = Math.min(min, dp[prevPos] + Math.min(diff, d - diff));
                }
                dp[curPos] = min;
            }
            prevPositions = currentPositions;
            prevChar = curChar;
        }
        int ans = Integer.MAX_VALUE;
        for (Integer prevPos : prevPositions) ans = Math.min(ans, dp[prevPos]);
        return ans + n;
    }
}
