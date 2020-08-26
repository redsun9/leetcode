package firecode;

public class MaxProfit {
    public static int maxProfit(int[] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) ans += a[i] - a[i - 1];
        }
        return ans;
    }
}
