package leetcode.leetcode12xx.leetcode1234;

@SuppressWarnings("StatementWithEmptyBody")
public class Solution {
    private static int getIdx(char c) {
        return switch (c) {
            case 'Q' -> 0;
            case 'W' -> 1;
            case 'E' -> 2;
            case 'R' -> 3;
            default -> throw new IllegalArgumentException();
        };
    }

    public int balancedString(String s) {
        int n = s.length();
        if (n % 4 != 0) return -1;

        int k = n / 4;
        int[] counts = {-k, -k, -k, -k};
        for (int i = 0; i < n; i++) counts[getIdx(s.charAt(i))]++;

        int over = 0;
        for (int i = 0; i < 4; i++) if (counts[i] > 0) over++;
        if (over == 0) return 0;

        int start = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            int idx = getIdx(s.charAt(i));
            counts[idx]--;
            if (counts[idx] == 0) over--;
            if (over == 0) {
                while (counts[getIdx(s.charAt(start++))]++ != 0) ; //empty body is intentional
                ans = Math.min(ans, i - start + 2);
                over = 1;
            }
        }
        return ans;
    }
}
