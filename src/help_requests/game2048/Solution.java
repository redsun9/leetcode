package help_requests.game2048;

public class Solution {
    public static void processLeftSwipe(int[] row) {
        int n = row.length;
        for (int l = -1, r = 0; r < n; r++) {
            if (row[r] == 0) continue;
            int num = row[r];
            row[r] = 0;
            while (l >= 0 && row[l] == num) {
                row[l--] = 0;
                num <<= 1;
            }
            row[++l] = num;
        }
    }

    public static void processLeftSwipeWithoutCascade(int[] row) {
        int n = row.length;
        for (int l = -1, r = 0; r < n; r++) {
            if (row[r] == 0) continue;
            int num = row[r];
            row[r] = 0;
            if (l >= 0 && row[l] == num) row[l++] = num * 2;
            else row[++l] = num;
        }
    }

    public static void processRightSwipe(int[] row) {
        int n = row.length;
        for (int r = n, l = n - 1; l >= 0; l--) {
            if (row[l] == 0) continue;
            int num = row[l];
            row[l] = 0;
            while (r < n && row[r] == num) {
                row[r++] = 0;
                num <<= 1;
            }
            row[--r] = num;
        }
    }

    public static void processRightSwipeWithoutCascade(int[] row) {
        int n = row.length;
        for (int r = n, l = n - 1; l >= 0; l--) {
            if (row[l] == 0) continue;
            int num = row[l];
            row[l] = 0;
            if (r < n && row[r] == num) row[r--] = num * 2;
            else row[--r] = num;
        }
    }
}
