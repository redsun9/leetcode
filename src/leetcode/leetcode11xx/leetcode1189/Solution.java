package leetcode.leetcode11xx.leetcode1189;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int countA = 0, countB = 0, countL = 0, countN = 0, countO = 0;
        for (int i = 0; i < n; i++) {
            switch (text.charAt(i)) {
                case 'a' -> countA++;
                case 'b' -> countB++;
                case 'l' -> countL++;
                case 'n' -> countN++;
                case 'o' -> countO++;
            }
        }
        return min(countA, countB, countL / 2, countN, countO / 2);
    }

    private static int min(int... arr) {
        int ans = Integer.MAX_VALUE;
        for (int a : arr) ans = Math.min(ans, a);
        return ans;
    }
}
