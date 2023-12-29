package help_requests.max_mountain_range;

public class DummySolution {
    public static long maxHeightSum(int[] maxHeights) {
        int n = maxHeights.length;
        long ans = 0L;

        for (int i = 0; i < n; i++) {
            long sum = maxHeights[i];
            for (int j = i - 1, maxPossible = maxHeights[i]; j >= 0; j--) {
                maxPossible = Math.min(maxPossible, maxHeights[j]);
                sum += maxPossible;
            }
            for (int j = i + 1, maxPossible = maxHeights[i]; j < n; j++) {
                maxPossible = Math.min(maxPossible, maxHeights[j]);
                sum += maxPossible;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
