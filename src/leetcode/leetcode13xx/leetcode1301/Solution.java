package leetcode.leetcode13xx.leetcode1301;

import java.util.List;

public class Solution {
    public static final int p = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();
        int[] prevMax = new int[n + 1], nextMax = new int[n + 1];
        int[] prevNum = new int[n + 1], nextNum = new int[n + 1];

        int[] tInt;
        ; //temporary variales fro swapping
        for (int i = m - 1; i >= 0; i--) {
            String s = board.get(i);
            for (int j = n - 1; j >= 0; j--) {
                char c = s.charAt(j);
                nextNum[j] = 0;
                if (c == 'X') {
                    nextMax[j] = 0;
                    continue;
                } else if (c == 'S') {
                    nextNum[j] = 1;
                    nextMax[j] = 1;
                    continue;
                } else if (c == 'E') {
                    nextMax[j] = 0;
                } else {
                    nextMax[j] = c - '0';
                }
                int maxScore = nextMax[j + 1];
                if (prevMax[j] > maxScore) maxScore = prevMax[j];
                if (prevMax[j + 1] > maxScore) maxScore = prevMax[j + 1];
                if (maxScore > 0) {
                    nextMax[j] += maxScore;
                    if (nextMax[j + 1] == maxScore) nextNum[j] += nextNum[j + 1];
                    if (prevMax[j] == maxScore) nextNum[j] += prevNum[j];
                    if (prevMax[j + 1] == maxScore) nextNum[j] += prevNum[j + 1];
                    nextNum[j] %= p;
                } else {
                    nextMax[j] = 0;
                    nextNum[j] = 0;
                }
            }

            tInt = prevMax;
            prevMax = nextMax;
            nextMax = tInt;

            tInt = prevNum;
            prevNum = nextNum;
            nextNum = tInt;
        }
        return new int[]{Math.max(prevMax[0] - 1, 0), prevNum[0]};
    }
}
