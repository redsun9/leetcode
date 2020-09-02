package leetcode.leetcode9xx.leetcode949;

public class Solution2 {
    public String largestTimeFromDigits(int[] arr) {
        int[] ans = new int[4];
        int max = -1;
        for (int a = 0; a < 4; a++) {
            if (arr[a] > 2) continue;
            for (int b = 0; b < 4; b++) {
                if (a == b || arr[a] * 10 + arr[b] > 23) continue;
                for (int c = 0; c < 4; c++) {
                    if (a == c || b == c || arr[c] > 5) continue;
                    int d = 6 - a - b - c;
                    int tmp = (arr[a] * 10 + arr[b]) * 60 + arr[c] * 10 + arr[d];
                    if (tmp > max) {
                        ans[0] = a;
                        ans[1] = b;
                        ans[2] = c;
                        ans[3] = d;
                        max = tmp;
                    }
                }
            }
        }
        return max >= 0 ? "" + arr[ans[0]] + arr[ans[1]] + ':' + arr[ans[2]] + arr[ans[3]] : "";
    }
}
