package suggestions.max_sum_of_k_special_string;

// there is an array of integers arr, and an integer k.
// Integer is called special if it is a negative number, and it's last digit is 3.
/// Array is called special if it contains EXACTLY k special integers.
// Find the maximum sum of elements between all special sub-arrays of arr.
// For example,
// A = [-3, 2, -3, 4, 5, -13], k = 2
// The maximum value of sum of subarray in the array is -3 + 2 - 3 + 4 + 5 = 5.
// Others special subarrays: [-3, 2, -3], [-3, 2, -3, 4], [-3, 2, -3, 4, 5], [2, -3, 4, 5, -13], [-3, 4, 5, -13]
// Return the maximum value of sum of k special integers in the array.
// it's guaranteed that there is at least K special integer in arr.

// O(N) time, O(1) space
// Two pointers / Sliding window solution + Greedy approach
public class Solution {
    public int maxSumOfKSpecial(int[] arr, int k) {
        int n = arr.length;
        int ans = k == 0 ? 0 : Integer.MIN_VALUE;
        int left = 0, right = 0, leftSum = 0, rightSum = 0, count = 0;
        int rightMaxSum;

        while (right < n) {
            if (arr[right] % 10 == -3) count++; //update count of special integers
            rightSum += arr[right++];
            while (count > k) { //this section is used only in case k==0
                if (arr[left] % 10 == -3) count--; //update count of special integers
                leftSum += arr[left++];
            }

            if (count == k) {
                // now we move right pointer until we meet end of array or meet another special integer
                // while iterating we update maximum sum of right
                rightMaxSum = rightSum;
                while (right < n && arr[right] % 10 != -3) {
                    rightSum += arr[right];
                    rightMaxSum = Math.max(rightSum, rightMaxSum);
                    right++;
                }

                // now we move left pointer until we meet end of array or meet another special integer
                // while iterating we update minimum sum of left
                while (left < n && count == k) {
                    ans = Math.max(ans, rightMaxSum - leftSum);
                    if (arr[left] % 10 == -3) count--;
                    leftSum += arr[left++];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-13 % 10);
    }
}
