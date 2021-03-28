package codejam.reverse_engineering;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int t1 = 0; t1 < t; t1++) {
            String[] parts = scanner.nextLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);
            int[] ans = generateArray(n, c);
            if (ans != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Case #").append(t1 + 1).append(":");
                for (int i = 0; i < n; i++) sb.append(" ").append(ans[i]);
                System.out.println(sb.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", (t1 + 1));
            }
        }
    }

    public static int[] generateArray(int n, int c) {
        c++;
        if (n > c || n * (n + 1) / 2 < c) return null;
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        boolean lastWasFromStart = true;
        int left = n;
        while (left != 0 && c >= 2 * left - 1) {
            if (lastWasFromStart) ans[r--] = n + 1 - left;
            else ans[l++] = n + 1 - left;
            lastWasFromStart = !lastWasFromStart;
            c -= left;
            left--;
        }
        int lastL, lastR;
        if (left != 0 && c > left) {
            lastL = lastWasFromStart ? l + c - left + 1 : l;
            lastR = lastWasFromStart ? r : r - c + left - 1;
            for (
                    int start = lastWasFromStart ? l + c - left : r - c + left,
                    end = lastWasFromStart ? l - 1 : r + 1,
                    diff = lastWasFromStart ? -1 : 1;
                    start != end
                    ; start += diff
            ) {
                ans[start] = n + 1 - left;
                left--;
            }
        } else {
            lastL = l;
            lastR = r;
        }
        while (lastL <= lastR) {
            if (lastWasFromStart) {
                ans[lastL] = n - (lastR - lastL);
                lastL++;
            } else {
                ans[lastR] = n - (lastR - lastL);
                lastR--;
            }
        }
        return ans;
    }
}
