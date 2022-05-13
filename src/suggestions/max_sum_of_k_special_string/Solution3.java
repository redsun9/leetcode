package suggestions.max_sum_of_k_special_string;

// We can precompute prefix sums of the array, and prefix counters of special numbers
// Precompute prefixes - O(N) - time, O(N) - space
// Iterate over all sub-arrays - O(N^2) - time, O(1) - space
// Overall - O(N^2) - time, O(N) - space

public class Solution3 {
    public int maxSumOfKSpecial(int[] arr, int k) {
        int n = arr.length;

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + arr[i];

        int[] prefixSpecial = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSpecial[i + 1] = prefixSpecial[i];
            if (arr[i] < 0 && arr[i] % 10 == -3) prefixSpecial[i + 1]++;
        }

        int max = k == 0 ? 0 : Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                int c = prefixSpecial[j + 1] - prefixSpecial[i];
                if (c == k && sum > max) max = sum;
            }
        }
        return max;
    }
}
