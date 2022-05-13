package suggestions.max_sum_of_k_special_string;

// The most brute force solution is to check all possible sub-arrays
// and find the k-special with the maximum sum.
// Time complexity: O(n^3), space complexity: O(1)
public class Solution2 {
    public int maxSumOfKSpecial(int[] arr, int k) {
        int n = arr.length;
        int max = k == 0 ? 0 : Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0, c = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                    if (arr[l] < 0 && arr[l] % 10 == -3) c++;
                }
                if (c == k && sum > max) max = sum;
            }
        }
        return max;
    }
}
